package com.helper.asynctask;

import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.system.GIFEncodedImage;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.component.BitmapField;

// TODO: Auto-generated Javadoc
//A field that displays an animated GIF.

/**
 * The Class AnimatedGIFField.
 */
public class AnimatedGIFField extends BitmapField {

	/** The _image. */
	private GIFEncodedImage _image; // The image to draw.
	
	/** The _current frame. */
	private int _currentFrame; // The current frame in the animation sequence.
	
	/** The _animator thread. */
	private AnimatorThread _animatorThread;

	/**
	 * Instantiates a new animated gif field.
	 *
	 * @param image the image
	 */
	public AnimatedGIFField(GIFEncodedImage image) {
		this(image, 0);
	}

	/**
	 * Instantiates a new animated gif field.
	 *
	 * @param image the image
	 * @param style the style
	 */
	public AnimatedGIFField(GIFEncodedImage image, long style) {
		/*
		 * Call super to setup the field with the specified style. The image is
		 * passed in as well for the field to configure its required size.
		 */
		super(image.getBitmap(), style);

		// Store the image and it's dimensions.
		_image = image;

		// Start the animation thread.
		_animatorThread = new AnimatorThread(this);
		_animatorThread.start();
	}

	/* (non-Javadoc)
	 * @see net.rim.device.api.ui.component.BitmapField#paint(net.rim.device.api.ui.Graphics)
	 */
	protected void paint(Graphics graphics) {
		// Call super.paint. This will draw the first background frame and
		// handle any required focus drawing.
		super.paint(graphics);

		// Don't redraw the background if this is the first frame.
		if (_currentFrame != 0) {
			// Draw the animation frame.
			graphics
					.drawImage(_image.getFrameLeft(_currentFrame), _image
							.getFrameTop(_currentFrame), _image
							.getFrameWidth(_currentFrame), _image
							.getFrameHeight(_currentFrame), _image,
							_currentFrame, 0, 0);
		}
	}

	// Stop the animation thread when the screen the field is on is
	// popped off of the display stack.
	/* (non-Javadoc)
	 * @see net.rim.device.api.ui.Field#onUndisplay()
	 */
	protected void onUndisplay() {
		_animatorThread.stop();
		super.onUndisplay();
	}

	// A thread to handle the animation.
	/**
	 * The Class AnimatorThread.
	 */
	private class AnimatorThread extends Thread {
		
		/** The _the field. */
		private AnimatedGIFField _theField;
		
		/** The _keep going. */
		private boolean _keepGoing = true;
		
		/** The _total frames. */
		private int _totalFrames; // The total number of frames in the image.
		
		/** The _loop count. */
		private int _loopCount; // The number of times the animation has looped
		// (completed).
		/** The _total loops. */
		private int _totalLoops; // The number of times the animation should

		// loop (set in the image).

		/**
		 * Instantiates a new animator thread.
		 *
		 * @param theField the the field
		 */
		public AnimatorThread(AnimatedGIFField theField) {
			_theField = theField;
			_totalFrames = _image.getFrameCount();
			_totalLoops = _image.getIterations();

		}

		/**
		 * Stop.
		 */
		public synchronized void stop() {
			_keepGoing = false;
		}

		/* (non-Javadoc)
		 * @see java.lang.Thread#run()
		 */
		public void run() {
			while (_keepGoing) {
				// Invalidate the field so that it is redrawn.
				UiApplication.getUiApplication().invokeAndWait(new Runnable() {
					public void run() {
						_theField.invalidate();
					}
				});

				try {
					// Sleep for the current frame delay before the next frame
					// is drawn.
					sleep(_image.getFrameDelay(_currentFrame) * 10);
				} catch (InterruptedException iex) {
				} // Couldn't sleep.

				// Increment the frame.
				++_currentFrame;

				if (_currentFrame == _totalFrames) {
					// Reset back to frame 0 if we have reached the end.
					_currentFrame = 0;

					++_loopCount;

					// Check if the animation should continue.
					if (_loopCount == _totalLoops) {
						_keepGoing = false;
					}
				}
			}
		}
	}
}
