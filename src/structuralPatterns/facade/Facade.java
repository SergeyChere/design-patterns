package structuralPatterns.facade;

public class Facade {
    public static void main(String[] args) {
        Converter converter = new Converter();
        converter.convertVideo("Forrest_Gump",".mp4");
        converter.convertAudio("Yesterday",".mp3");
        converter.convertPicture("My_cat's_photo",".jpg");
    }

    public static class Converter {
        private static VideoFormat videoFormat;
        private static AudioFormat audioFormat;
        private static PictureFormat pictureFormat;

        public Converter() {
            this.videoFormat = new VideoFormat();
            this.audioFormat = new AudioFormat();
            this.pictureFormat = new PictureFormat();
        }

        public static void convertVideo (String filename, String format) {
            videoFormat.convert(filename, format);
        }

        public static void convertAudio (String filename, String format) {
            audioFormat.convert(filename, format);
        }

        public static void convertPicture (String filename, String format) {
            pictureFormat.convert(filename, format);
        }

    }

    public interface File {
        void convert(String filename, String format);
    }

    public static class VideoFormat implements File {
        @Override
        public void convert(String filename, String format) {
            System.out.println("I'm video: "+filename+format);
        }
    }

    public static class AudioFormat implements File {
        @Override
        public void convert(String filename, String format) {
            System.out.println("I'm audio: "+filename+format);
        }
    }

    public static class PictureFormat implements File {
        @Override
        public void convert(String filename, String format) {
            System.out.println("I'm picture: "+filename+format);
        }
    }
}
