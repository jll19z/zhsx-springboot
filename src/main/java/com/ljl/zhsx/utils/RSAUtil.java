package com.ljl.zhsx.utils;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @author L.J.L
 * @QQ 963314043
 * @date 2022/8/13 20:53
 */
public class RSAUtil {

    // 私钥字符串
    private static String privateKeyStr;

    // 公钥字符串
    private static String publicKeyStr;

    public static String getPublicKeyStr() {
        return publicKeyStr;
    }

    /**
     * 获取公钥私钥
     */
    public static void initKey() {
        try {
            Base64.Encoder encoder = Base64.getEncoder();
            // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
            // 初始化密钥对生成器，密钥大小为96-1024位
            keyPairGen.initialize(1024, new SecureRandom());
            // 生成一个密钥对，保存在keyPair中
            KeyPair keyPair = keyPairGen.generateKeyPair();
            // 得到私钥
            RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
            // 得到公钥
            RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

            privateKeyStr = new String(encoder.encode((privateKey.getEncoded())));
            publicKeyStr = new String(encoder.encode(publicKey.getEncoded()));
        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
        }

    }

    /**
     * RSA公钥加密
     *
     * @param str       加密字符串
     * @param publicKey 公钥
     */
    public static String encrypt(String str, String publicKey) {
        try {
            Base64.Decoder decoder = Base64.getDecoder();
            Base64.Encoder encoder = Base64.getEncoder();
            //base64编码的公钥
            byte[] decoded = decoder.decode(publicKey);
            RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
            //RSA加密
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            String outStr = encoder.encodeToString(cipher.doFinal(str.getBytes("UTF-8")));
            return outStr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * RSA私钥解密
     *
     * @param str        加密字符串
     */
    public static String decrypt(String str) {
        try {
            Base64.Decoder decoder = Base64.getDecoder();
            //64位解码加密后的字符串
            byte[] inputByte = decoder.decode(str.getBytes("UTF-8"));
            //base64编码的私钥
            byte[] decoded = decoder.decode(privateKeyStr);
            RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
            //RSA解密
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, priKey);
            String outStr = new String(cipher.doFinal(inputByte));
            return outStr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
