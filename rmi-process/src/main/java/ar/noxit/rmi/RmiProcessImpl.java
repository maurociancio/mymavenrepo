package ar.noxit.rmi;

public class RmiProcessImpl implements RmiProcess {

    public RmiProcessImpl() {
    }

    public Process createRmiProcess() {
        try {
            String[] env = { "CLASSPATH=" + getClassPath() };

            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec("rmiregistry", env);

            Thread.sleep(200);
            return process;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    private String getClassPath() {
        return System.getProperties().getProperty("java.class.path", null);
    }
}
