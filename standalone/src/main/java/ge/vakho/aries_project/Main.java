package ge.vakho.aries_project;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;

/**
 * @author vakho
 */
public class Main {

	static final String PATH = "file:\\D:\\Java Workspaces\\Servlets Workspace\\aries-project\\";
	static final String STANDALONE_BUNDLES_PATH = PATH + "standalone\\bundles\\";
	
	public static void main(String[] args) throws BundleException, InterruptedException {

		FrameworkFactory frameworkFactory = ServiceLoader.load(FrameworkFactory.class) //
				.iterator().next();

		Framework framework = frameworkFactory.newFramework(getConfig());

		framework.start(); // Start framework

		BundleContext bc = framework.getBundleContext();

		// Register and start default container bundles
		initContainerDefaults(bc);

		// Install & start API service
		bc.installBundle(PATH + "hello-api\\target\\hello-api.jar").start();
		
		// Install & start hello services
		bc.installBundle(PATH + "hello-english\\target\\hello-english.jar").start();
		bc.installBundle(PATH + "hello-georgian\\target\\hello-georgian.jar").start();
		bc.installBundle(PATH + "hello-russian\\target\\hello-russian.jar").start();
		
		// Install & start hello services executor
		bc.installBundle(PATH + "hello-executor\\target\\hello-executor.jar").start();
		bc.installBundle(PATH + "hello-executor-annotated\\target\\hello-executor-annotated.jar").start();
		
		// Just for test :) let's wait 5 seconds before stopping framework
		new Thread(() -> {
			try {
				Thread.sleep(5 * 1000);
				framework.stop();
			} catch (BundleException | InterruptedException e) {
				e.printStackTrace();
				System.exit(0); // XXX or should it be -1? :d
			}
		}).start();
		
		framework.waitForStop(0);
	}

	private static void initContainerDefaults(BundleContext bc) throws BundleException {
		// Aries Utils
		bc.installBundle(STANDALONE_BUNDLES_PATH + "org.apache.aries.util-1.1.1.jar").start();
		
		// Some CM bundle for Blueprint
		bc.installBundle(STANDALONE_BUNDLES_PATH + "org.osgi.service.cm-1.5.0.jar").start();
		
		// fragment (needs no start!)
		bc.installBundle(STANDALONE_BUNDLES_PATH + "slf4j-simple-1.7.12.jar");
		
		bc.installBundle(STANDALONE_BUNDLES_PATH + "slf4j-api-1.7.12.jar").start();
		bc.installBundle(STANDALONE_BUNDLES_PATH + "org.apache.aries.proxy-1.1.1.jar").start();

		bc.installBundle(STANDALONE_BUNDLES_PATH + "org.apache.aries.blueprint-1.1.0.jar").start();
	}

	private static Map<String, String> getConfig() {
		HashMap<String, String> config = new HashMap<>();
		config.put("osgi.clean", "true");
		return config;
	}
}