package concurrent.mutex;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by xiongxiaoyu
 * Data:2019/3/4
 * Time:22:30
 */
public class Mutex implements Lock,Serializable{


	private static class Sync extends AbstractQueuedSynchronizer {
		// Reports whether in locked state
		@Override
		protected boolean isHeldExclusively() {
			return getState() == 1;
		}

		// Acquires the lock if state is zero
		@Override
		public boolean tryAcquire(int acquires) {
			assert acquires == 1;
			// Otherwise unused
			if (compareAndSetState(0, 1)) {
				setExclusiveOwnerThread(Thread.currentThread());
				return true;
			}
			return false;
		}

		// Releases the lock by setting state to zero
		@Override
		protected boolean tryRelease(int releases) {
			assert releases == 1;
			// Otherwise unused
			if (getState() == 0) {
				throw new IllegalMonitorStateException();
			}
			setExclusiveOwnerThread(null);
			setState(0);
			return true;
		}

		// Provides a Condition
		Condition newCondition() {
			return new ConditionObject();
		}

		// Deserializes properly
		private void readObject(ObjectInputStream s)
				throws IOException, ClassNotFoundException {
			s.defaultReadObject();
			setState(0);
			// reset to unlocked state
		}
	}


	// The sync object does all the hard work. We just forward to it.
	private final Sync sync = new Sync();
	//使用同步器的模板方法实现自己的同步语义

	@Override
	public void lock() {
		sync.acquire(1);
	}

	@Override
	public boolean tryLock() {
		return sync.tryAcquire(1);
	}

	@Override
	public void unlock() {
		sync.release(1);
	}

	@Override
	public Condition newCondition() {
		return sync.newCondition();
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		sync.acquireInterruptibly(1);
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return sync.tryAcquireNanos(1,unit.toNanos(time));
	}
}
