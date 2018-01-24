package org.ju.cse.gobinda.ai.faceDetection;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.objdetect.CascadeClassifier;

public class FaceDetector {

	public static void main(String[] args) {
		detectFace("C:\\Users\\User\\Desktop\\a.png");
	}

	public static String detectFace(String inputFile) {
		try {
			nu.pattern.OpenCV.loadShared();
			System.loadLibrary(org.opencv.core.Core.NATIVE_LIBRARY_NAME);

			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
			System.out.println("\nRunning FaceDetector");

			CascadeClassifier faceDetector = new CascadeClassifier(
					"C:\\Users\\User\\Desktop\\neural network\\java work\\face detection\\knowledge\\haarcascade_frontalface_alt.xml");

			Mat image = Highgui.imread(inputFile);

			MatOfRect faceDetections = new MatOfRect();
			faceDetector.detectMultiScale(image, faceDetections);

			System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));

			for (Rect rect : faceDetections.toArray()) {
				Core.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
						new Scalar(0, 255, 0));
			}

			String filename = "C:\\Windows\\Temp\\ouput.png";
			// System.out.println(String.format("Writing %s", filename));
			Highgui.imwrite(filename, image);
			return filename;
		} catch (Exception e) {
			System.out.println("problem occurs");
			e.printStackTrace();
		}
		return null;
	}
}