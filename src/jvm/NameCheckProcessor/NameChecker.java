package jvm.NameCheckProcessor;

import javax.annotation.processing.Messager;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementScanner6;

/**
 * Created by xiongxiaoyu
 * Data:2018/12/19
 * Time:15:37
 *
 *
 */
public class NameChecker {

	private final Messager messager;

	public NameChecker(Messager messager) {
		this.messager = messager;
	}

	NameCheckScanner nameCheckScanner = new NameCheckScanner();



	private class NameCheckScanner extends ElementScanner6<Void,Void>{

		@Override
		public Void visitType(TypeElement e, Void aVoid) {
			scan(e.getTypeParameters(),aVoid);

			return super.visitType(e, aVoid);
		}

		@Override
		public Void visitVariable(VariableElement e, Void aVoid) {
			return super.visitVariable(e, aVoid);
		}

		@Override
		public Void visitExecutable(ExecutableElement e, Void aVoid) {
			return super.visitExecutable(e, aVoid);
		}



//		//判断一个变量是不是常量
//		private boolean heuristicallyConstant(VariableElement e){
//			if (e.getEnclosingElement().getKind() == ElementKind.INTERFACE)
//			{
//				return true;
//			}
//			else if(e.getKind() == ElementKind.FIELD && e.getModifiers().containsAll(EnumSet.of(PUBULIC,STATIC,FINAL)))
//			{
//				return false;
//			}
//			else {
//				return false;
//			}
//		}



	}
}
