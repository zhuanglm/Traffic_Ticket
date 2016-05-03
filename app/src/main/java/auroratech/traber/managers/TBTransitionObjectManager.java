package auroratech.traber.managers;

import android.graphics.Bitmap;
import android.net.Uri;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by E on 4/5/2016.
 */
public class TBTransitionObjectManager {

    /*
    *   URI LIST
    * */
    private ArrayList<Uri> fileUrls;

    public void clearUrls() {
        fileUrls.clear();
    }

    public void addUrl(Uri uri) {
        fileUrls.add(uri);
    }

    public ArrayList<Uri> getStashOfUrls() {
        return fileUrls;
    }

    public void deleteAllImage() {
        for (Uri uri : fileUrls.toArray(new Uri[]{})) {
            File file = new File(uri.getPath());
            if(file.exists()){
                file.delete();

                // remove
                fileUrls.remove(uri);
            }
        }

        // also get rid of this
        acceptableFile = null;
    }

    /**
     *      Current uri to use
     */
    public Uri acceptableFile;



    /*
    *   PHOTO ITEMS
    * */
    private ArrayList<Bitmap> imageList;

    public void clearImageList() {
        imageList.clear();
    }

    public void addImage(Bitmap bitmap) {
        imageList.add(bitmap);
    }

    public ArrayList<Bitmap> getImageList() {
        return imageList;
    }

    public boolean isThereImage() {
        return imageList.size() > 0;
    }



    /*
    *   CONSTRUCTOR (UPDATE)
    * */
    private TBTransitionObjectManager(){
        fileUrls = new ArrayList<Uri>();
        imageList = new ArrayList<Bitmap>();

    }

    private static TBTransitionObjectManager instance;

    public static synchronized TBTransitionObjectManager getInstance( ) {
        if(instance == null) {
            instance = new TBTransitionObjectManager();
        }
        return instance;
    }
}
