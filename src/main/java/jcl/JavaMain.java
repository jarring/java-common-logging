package jcl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class JavaMain {

	static void runThread(Log log) {

		log.trace(Thread.currentThread().getName());
		log.debug(Thread.currentThread().getName());
		log.info(Thread.currentThread().getName());
		log.warn(Thread.currentThread().getName());
		log.error(Thread.currentThread().getName());
		log.fatal(Thread.currentThread().getName());

	}

	public static void main(String[] args) {
		System.setProperty(LogFactory.DIAGNOSTICS_DEST_PROPERTY, "STDOUT");
		final Log log = LogFactory.getLog(JavaMain.class);

		new Thread() {
			public void run() {
				while (System.currentTimeMillis() > 0) {
					runThread(log);
					try {
						sleep(10000);
					} catch (InterruptedException e) {
						this.interrupt();
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

}
