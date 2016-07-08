# eap5
copy ejb-interceptors.. to a eap5 installation in jboss-as/server/default/deploy
start the server
Run HelloClient to test the client interceptor
Run localhost:8080/TestInterceptorTester/TestInterceptorServlet?printMessage=somemessage to test the server interceptor