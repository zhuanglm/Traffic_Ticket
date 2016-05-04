package auroratech.traber;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import auroratech.traber.base.TBActivityBase;
import auroratech.traber.managers.TBTransitionObjectManager;
import auroratech.traber.managers.TBUIManager;
import auroratech.traber.util.ImageUtil;


public class TBPhotoActivity extends TBActivityBase {

    public static final String TAG_FROM_ACTIVITY = "FROM_ACTIVITY";
    //    constants
    public static final String CONST_FROM_ADD_TICKET = "FROM_ADD_TICKET";
    public static final String CONST_FROM_ADD_CAR = "FROM_ADD_CAR";
    public static final String CONST_FROM_ADD_DRIVER_LICENSE = "FROM_ADD_DRIVER_LICENSE";


    private boolean isFromAddTicket = false;
    private boolean isFromAddCar = false;
    private boolean isFromAddDriverLicense = false;


    TBActivityBase current;

    // Activity request codes
    private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;
    private static final int CAMERA_CAPTURE_VIDEO_REQUEST_CODE = 200;
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;

    // directory name to store captured images and videos
    private static final String IMAGE_DIRECTORY_NAME = "TBCamera";

    private Uri fileUri; // file url to store image/video


    auroratech.traber.common.ui.TBHeader profileHeaderSection;
    RelativeLayout myTicketViewItemsContent;
    TextView imgPreviewText;
    ImageView imgPreview;
    Button btnCapturePicture;
    LinearLayout reTakeToolBar;
    Button btnReCapturePictureBtn;
    Button btnCapturePictureOkBtn;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tb_photo);

        current = this;


        profileHeaderSection = (auroratech.traber.common.ui.TBHeader) findViewById(R.id.profileHeaderSection);
        myTicketViewItemsContent = (RelativeLayout) findViewById(R.id.myTicketViewItemsContent);
        imgPreviewText = (TextView) findViewById(R.id.imgPreviewText);
        imgPreview = (ImageView) findViewById(R.id.imgPreview);
        btnCapturePicture = (Button) findViewById(R.id.btnCapturePicture);
        reTakeToolBar = (LinearLayout) findViewById(R.id.reTakeToolBar);
        btnReCapturePictureBtn = (Button) findViewById(R.id.btnReCapturePictureBtn);
        btnCapturePictureOkBtn = (Button) findViewById(R.id.btnCapturePictureOkBtn);

        //btnRecordVideo = (Button) findViewById(R.id.btnRecordVideo);


        profileHeaderSection.setActivityReference(this);

        /**
         * Capture image button click event
         */
        btnCapturePicture.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            // hide this button
            btnCapturePicture.setVisibility(View.GONE);

            // capture picture
            captureImage();
            }
        });

        btnReCapturePictureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reTakeToolBar.setVisibility(View.GONE);

                // capture picture
                captureImage();

            }
        });

        btnCapturePictureOkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TBTransitionObjectManager.getInstance().acceptableFile = fileUri;

                if (isFromAddTicket) {
                    TBUIManager.getInstance().ToMyTicketAddTicket(current);

                } else if (isFromAddCar) {
                    TBUIManager.getInstance().ToMyCarAddCar(current);

                } else if (isFromAddDriverLicense) {

                    TBUIManager.getInstance().ToMyProfileAddLicensePage(current);
                }

            }
        });

        /**
         * Record video button click event
         */
//        btnRecordVideo.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//            // record video
//            //recordVideo();
//            }
//        });

        // Checking camera availability
        if (!isDeviceSupportCamera()) {
            Toast.makeText(getApplicationContext(),
                    "Sorry! Your device doesn't support camera",
                    Toast.LENGTH_LONG).show();
            // will close the app if the device doesn't have camera
            finish();
        }

        // get intent
        Intent intent = getIntent();
        String fromActivity = intent.getStringExtra(TAG_FROM_ACTIVITY);

        switch (fromActivity) {
            case CONST_FROM_ADD_TICKET: {
                isFromAddTicket = true;
                break;
            }
            case CONST_FROM_ADD_CAR: {
                isFromAddCar = true;
                break;
            }
            case CONST_FROM_ADD_DRIVER_LICENSE: {
                isFromAddDriverLicense = true;
                break;
            }
            default: {
                Toast.makeText(getApplicationContext(),
                        "Incorrectly started photo activity...",
                        Toast.LENGTH_LONG).show();

                finish();
            }
        }
        captureImage();

    }

    /**
     * Checking device has camera hardware or not
     * */
    private boolean isDeviceSupportCamera() {
        return getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA) && (Camera.getNumberOfCameras() > 0);
    }

    /**
     * Capturing Camera Image will launch camera app request image capture
     */
    private void captureImage() {

        fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
        if(fileUri == null) {
            Toast.makeText(getApplicationContext(),
                    "Problem saving captured image...",
                    Toast.LENGTH_LONG).show();

            finish();
        }

        // add to tracker
        TBTransitionObjectManager.getInstance().addUrl(fileUri);

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);

        // start the image capture Intent
        startActivityForResult(intent, CAMERA_CAPTURE_IMAGE_REQUEST_CODE);
    }

    /**
     * Here we store the file url as it will be null after returning from camera
     * app
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // save file url in bundle as it will be null on scren orientation
        // changes
        outState.putParcelable("file_uri", fileUri);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // get the file url
        fileUri = savedInstanceState.getParcelable("file_uri");
    }

    /**
     * Recording video (not needed right now)
     */
    private void recordVideo() {
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

        fileUri = getOutputMediaFileUri(MEDIA_TYPE_VIDEO);

        // set video quality
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file
        // name

        // start the video capture Intent
        startActivityForResult(intent, CAMERA_CAPTURE_VIDEO_REQUEST_CODE);
    }

    /**
     * Receiving activity result method will be called after closing the camera
     * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // if the result is capturing Image
        if (requestCode == CAMERA_CAPTURE_IMAGE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                // post process this part
                postImageCaptureOperation();

                // successfully captured the image
                // display it in image view
                previewCapturedImage();

            } else if (resultCode == RESULT_CANCELED) {
                // user cancelled Image capture
//                Toast.makeText(getApplicationContext(),
//                        "User cancelled image capture", Toast.LENGTH_SHORT)
//                        .show();

                btnCapturePicture.setVisibility(View.VISIBLE);

            } else {
                // failed to capture image
                Toast.makeText(getApplicationContext(),
                        "Sorry! Failed to capture image", Toast.LENGTH_SHORT)
                        .show();
            }
        } else if (requestCode == CAMERA_CAPTURE_VIDEO_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // video successfully recorded
                // preview the recorded video
                previewVideo();
            } else if (resultCode == RESULT_CANCELED) {
                // user cancelled recording
                Toast.makeText(getApplicationContext(),
                        "User cancelled video recording", Toast.LENGTH_SHORT)
                        .show();
            } else {
                // failed to record video
                Toast.makeText(getApplicationContext(),
                        "Sorry! Failed to record video", Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }

    private void postImageCaptureOperation() {
        // need to rotate image if taken side way
        ImageUtil.fromGallery(current, fileUri);
    }

    /**
     * Display image from a path to ImageView
     */
    private void previewCapturedImage() {
        try {
//            // hide video preview
//            videoPreview.setVisibility(View.GONE);

            reTakeToolBar.setVisibility(View.VISIBLE);

            imgPreview.setVisibility(View.VISIBLE);

            // bitmap factory
            BitmapFactory.Options options = new BitmapFactory.Options();

            // downsizing image as it throws OutOfMemory Exception for larger
            // images
            options.inSampleSize = 4;

            final Bitmap bitmap = BitmapFactory.decodeFile(fileUri.getPath(),
                    options);

            imgPreview.setImageBitmap(bitmap);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    /**
     * Previewing recorded video
     */
    private void previewVideo() {
//        try {
//            // hide image preview
//            imgPreview.setVisibility(View.GONE);
//
//            videoPreview.setVisibility(View.VISIBLE);
//            videoPreview.setVideoPath(fileUri.getPath());
//            // start playing
//            videoPreview.start();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    /**
     * ------------ Helper Methods ----------------------
     * */

    /**
     * Creating file uri to store image/video
     */
    public Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }

    /**
     * returning image / video
     */
    private static File getOutputMediaFile(int type) {

        // External sdcard location
        File mediaStorageDir = new File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                IMAGE_DIRECTORY_NAME);

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d(IMAGE_DIRECTORY_NAME, "Failed create " + IMAGE_DIRECTORY_NAME + " directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator + "IMG_" + timeStamp + ".jpg");
        } else if (type == MEDIA_TYPE_VIDEO) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator + "VID_" + timeStamp + ".mp4");
        } else {
            return null;
        }

        return mediaFile;
    }

    private void ClearTakenPicture() {

    }

    @Override
    public void BackPressed() {
        // for back press from header
        if (isFromAddTicket) {
            TBUIManager.getInstance().ToMyTicketAddTicket(current);

        } else if (isFromAddCar) {
            TBUIManager.getInstance().ToMyCarAddCar(current);

        } else if (isFromAddDriverLicense) {
            TBUIManager.getInstance().ToMyProfileAddLicensePage(current);

        }
    }

/*

profileHeaderSection = null;
myTicketViewItemsContent = null;
imgPreviewText = null;
imgPreview = null;
btnCapturePicture = null;
reTakeToolBar = null;
btnReCapturePictureBtn = null;
btnCapturePictureOkBtn = null;


*/



}
