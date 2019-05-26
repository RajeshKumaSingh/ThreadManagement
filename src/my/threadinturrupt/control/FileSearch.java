package my.threadinturrupt.control;

import java.io.File;

public class FileSearch implements Runnable {
	
	/*
	If the implements a complex algorithm divided into some methods,
	or it has methods with recursive calls, we can use a better mechanism to control
	the interruption of Thread. Java provides the InterruptException exception for this Purpose.
	We can throw this exception when we detect the interruption of the thread and catch it in the run method.
	*/

	private String initPath;
	private String fileName;
	
	public FileSearch(String initPath, String fileName) {
		super();
		this.initPath = initPath;
		this.fileName = fileName;
	}

	@Override
	public void run() {
		File file = new File(initPath);
		System.out.printf("Directory is %s and fileName is %s",initPath,fileName);
		if(file.isDirectory()) {
			try {
				directoryProcess(file);
			}catch(InterruptedException ie) {
				System.out.printf("\n%s: The search has been interrupted", Thread.currentThread().getName());
			}
			
		}
	}

	private void directoryProcess(File file) throws InterruptedException {
		File[] list = file.listFiles();
		if(list!=null) {
			for(int i=0;i<list.length;i++) {
				if(list[i].isDirectory()) {
					directoryProcess(list[i]);
				}else {
					fileProcess(list[i]);
				}
			}
		}
		if(Thread.interrupted()) {
			throw new InterruptedException();
		}
	}

	private void fileProcess(File file)  throws InterruptedException {
		if(file.getName().equals(fileName)) {
			System.out.printf("\n%s: %s\n",Thread.currentThread().getName(),file.getAbsolutePath());
		}
		if(Thread.interrupted()) {
			throw new InterruptedException();
		}
	}

}
