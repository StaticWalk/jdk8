package org.omg.PortableInterceptor;


/**
* org/omg/PortableInterceptor/IORInterceptor.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u112/7884/corba/src/share/classes/org/omg/PortableInterceptor/Interceptors.idl
* Thursday, September 22, 2016 9:33:09 PM PDT
*/


/**
   * Interceptor used to establish tagged components in the profiles within 
   * an IOR.
   * <p>
   * In some cases, a portable ORB service implementation may need to add 
   * information describing the server's or object's ORB service related 
   * capabilities to object references in order to enable the ORB service 
   * implementation in the client to function properly. 
   * <p>
   * This is supported through the <code>IORInterceptor</code> and 
   * <code>IORInfo</code> interfaces. 
   *
   * @see IORInfo
   */
public interface IORInterceptor extends IORInterceptorOperations, org.omg.PortableInterceptor.Interceptor, org.omg.CORBA.portable.IDLEntity 
{
} // interface IORInterceptor
