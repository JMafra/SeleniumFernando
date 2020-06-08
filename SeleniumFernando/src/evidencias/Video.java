package evidencias;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class Video {
	ATUTestRecorder recorder;

	public Video(String pathVideo, String nameVideo) throws ATUTestRecorderException {

		// DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		// Date date = new Date();
		// Created object of ATUTestRecorder
		// Provide path to store videos and file name format.

		this.recorder = new ATUTestRecorder(pathVideo, nameVideo,false);

	}

	public void inicio() throws ATUTestRecorderException {
		recorder.start();
	}

	public void fim() throws ATUTestRecorderException {
		recorder.stop();
	}

}