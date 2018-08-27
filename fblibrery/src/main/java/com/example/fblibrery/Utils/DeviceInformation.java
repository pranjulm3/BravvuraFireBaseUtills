package com.example.fblibrery.Utils;

import android.os.Build;

/**
 * Created by munchado on 13-08-2018.
 */

public class DeviceInformation {
    private String os_version, sdk, brand, display, version_release, version, device, model, product;
    private static DeviceInformation instance;

    private DeviceInformation() {

    }

    public static DeviceInformation getInstance() {
        if (instance == null) {

            if (instance == null) {

                instance=new DeviceInformation ();
            }


        }
        return instance;
    }

    public String getOs_version() {
        return System.getProperty ( "os.version" );
    }

    public void setOs_version(String os_version) {
        this.os_version=os_version;
    }

    public String getSdk() {
        return Build.VERSION.SDK;
    }

    public void setSdk(String sdk) {
        this.sdk=sdk;
    }

    public String getBrand() {
        return Build.BRAND;
    }

    public void setBrand(String brand) {
        this.brand=brand;
    }

    public String getDisplay() {
        return Build.DISPLAY;
    }

    public void setDisplay(String display) {
        this.display=display;
    }

    public String getVersion_release() {
        return Build.VERSION.RELEASE;
    }

    public void setVersion_release(String version_release) {
        this.version_release=version_release;
    }

    public String getVersion() {
        return Build.DEVICE;
    }

    public void setVersion(String version) {
        this.version=version;
    }

    public String getDevice() {
        return Build.DEVICE;
    }

    public void setDevice(String device) {
        this.device=device;
    }

    public String getModel() {
        return Build.MODEL;
    }

    public void setModel(String model) {
        this.model=model;
    }

    public String getProduct() {
        return Build.PRODUCT;
    }

    public void setProduct(String product) {
        this.product=product;
    }

    public static void setInstance(DeviceInformation instance) {
        DeviceInformation.instance=instance;
    }
}
