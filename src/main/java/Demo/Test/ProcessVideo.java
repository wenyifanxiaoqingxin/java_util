package Demo.Test;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by fx on 2018/9/29.
 */
public class ProcessVideo {

    public static void fetchFrame(String videoFile,String frameFile) throws FrameGrabber.Exception, IOException {

        long start = System.currentTimeMillis();
        File file = new File(frameFile);
        FFmpegFrameGrabber fFmpegFrameGrabber = new FFmpegFrameGrabber(videoFile);
        fFmpegFrameGrabber.start();
        int lenght = fFmpegFrameGrabber.getLengthInFrames();
        int i =0;
        Frame frame = null;

        while(i<lenght){
            //取出五帧避免拿到图片为黑色
            frame= fFmpegFrameGrabber.grabFrame();
            if((i>5)&&(frame.image!=null)){
                break;
            }
            i++;
        }

        Java2DFrameConverter converter = new Java2DFrameConverter();
        BufferedImage bufferedImage = converter.getBufferedImage(frame);
        ImageIO.write(bufferedImage,"jpg",file);
        fFmpegFrameGrabber.stop();
        System.out.println("截取成功："+ (System.currentTimeMillis()-start));
    }

    public static void main(String[] args) {
        try {
            ProcessVideo.fetchFrame("/Users/crionline/Desktop/ccc.mp4","/Users/crionline/Desktop/ccc.jpg");
        }catch (Exception e){
            e.printStackTrace();
            e.getStackTrace();
        }
    }
}
