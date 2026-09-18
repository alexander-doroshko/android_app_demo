package com.example.core.network;

public final class NetworkConfig {

    private NetworkConfig() {}

    public static final String BASE_URL = "https://api.example.com/";
    public static final int CONNECT_TIMEOUT_SECONDS = 30;
    public static final int READ_TIMEOUT_SECONDS = 30;
    public static final int WRITE_TIMEOUT_SECONDS = 30;
    public static final boolean ENABLE_LOGGING = true;
}
