package com.helper.asynctask;

import net.rim.device.api.ui.UiApplication;

// TODO: Auto-generated Javadoc
/**
 * The Class AsyncTask.
 */
public abstract class AsyncTask implements Runnable {
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		// TODO Auto-generated method stub
		UiApplication.getUiApplication().invokeLater(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				onPreExecute();
			}
		});

		doInBackground();
		
		UiApplication.getUiApplication().invokeLater(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				onPostExecute();
			}
		});
	}

	/**
	 * On pre execute.
	 */
	public abstract void onPreExecute();

	/**
	 * Do in background.
	 */
	public abstract void doInBackground();

	/**
	 * On post execute.
	 */
	public abstract void onPostExecute();

	/**
	 * On execute.
	 */
	public void onExecute() {
		Thread theRunner = new Thread(this);
		theRunner.start();
	}
}
