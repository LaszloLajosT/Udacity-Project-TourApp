package com.example.android.tour;

import java.util.StringTokenizer;

public class GuideInformation {

    /** Logo resource ID for the Guide */
    private int mLogoImageResourceId;

    /** Main Image resource ID for the Guide */
    private int mImageResourceId;

    /** Name of the Restaurant/Pub/place/Event */
    private String mGeneralName;

    /** Description for the Guide */
    private String mDescription;

    /** Address for the Guide */
    private String mAddress;

    /** Phone details for the Guide */
    private String mPhoneNumber;

    /** Opening times for the Guide */
    private String mOpenTimes;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     *
     * Create a new Guide object.
     *
     * @param logoImageResourceId is the image on the list like a logo
     * @param imageResourceId is the image on the details screen
     * @param generalName is the name of the Guide
     * @param description is the description of the Guide
     * @param address is the address of the Guide
     * @param phoneNumber is the phone number of the Guide
     * @param openTimes is the opening times of the Guide
     */
    public GuideInformation(int logoImageResourceId,int imageResourceId, String generalName, String description, String address,String phoneNumber, String openTimes) {
        mLogoImageResourceId = logoImageResourceId;
        mImageResourceId = imageResourceId;
        mGeneralName =  generalName;
        mDescription = description;
        mAddress = address;
        mPhoneNumber = phoneNumber;
        mOpenTimes = openTimes;
    }

    /**
     * Return the logo resource ID of the Guide.
     */
    public int getmLogoImageResourceId() {
        return mLogoImageResourceId;
    }


    public void setmLogoImageResourceId(int mLogoImageResourceId) {
        this.mLogoImageResourceId = mLogoImageResourceId;
    }

    /**
     * Return the image resource ID of the Guide.
     */
    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public void setmImageResourceId(int mImageResourceId) {
        this.mImageResourceId = mImageResourceId;
    }

    /**
     * Get the name  of the Guide.
     */
    public String getmGeneralName() {
        return mGeneralName;
    }

    public void setmGeneralName(String mGeneralName) {
        this.mGeneralName = mGeneralName;
    }

    /**
     * Get the description  of the Guide.
     */
    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    /**
     * Get the address  of the Guide.
     */
    public String getmAddress() {
        String result = "Address:\n";
        StringTokenizer tokenizer = new StringTokenizer(mAddress, ",");
        while (tokenizer.hasMoreTokens()) {
            result = result + tokenizer.nextToken() + "\n";
            //System.out.println(tokenizer.nextToken());
        }
        return result;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    /**
     * Get the phone number  of the Guide.
     */
    public String getmPhoneNumber() {

        return "Phone: " + mPhoneNumber;
    }

    public void setmPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }

    /**
     * Get the default translation of the word.
     */
    public String getmOpenTimes() {
        String result = "Open Hours:\n";
        StringTokenizer tokenizer = new StringTokenizer(mOpenTimes, ",");
        while (tokenizer.hasMoreTokens()) {
            result = result + tokenizer.nextToken() + "\n";
            //System.out.println(tokenizer.nextToken());
        }
        return result;
    }

    public void setmOpenTimes(String mOpenTimes) {
        this.mOpenTimes = mOpenTimes;
    }

    @Override
    public String toString() {
        return "GuideInformation{" +
                ", mLogoImageResourceId=" + mLogoImageResourceId +
                ", mImageResourceId='" + mImageResourceId + '\'' +
                ", mGeneralName='" + mGeneralName + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mAddress='" + mAddress + '\'' +
                ", mPhoneNumber='" + mPhoneNumber + '\'' +
                ", mOpenTimes='" + mOpenTimes + '\'' +
                '}';
    }
}
