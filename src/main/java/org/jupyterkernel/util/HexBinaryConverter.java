/*
 * Copyright 2018 z003n2ej.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jupyterkernel.util;

/**
 *
 * @author z003n2ej
 */
public class HexBinaryConverter {

    private static int hexToBin(char ch) {
        if ('0' <= ch && ch <= '9') {
            return ch - '0';
        }
        if ('A' <= ch && ch <= 'F') {
            return ch - 'A' + 10;
        }
        if ('a' <= ch && ch <= 'f') {
            return ch - 'a' + 10;
        }
        return -1;
    }

    public static byte[] parseHexBinary(String s) {
        final int len = s.length();

        // "111" is not a valid hex encoding.
        if (len % 2 != 0) {
            return null;
        }

        byte[] out = new byte[len / 2];

        for (int i = 0; i < len; i += 2) {
            int h = hexToBin(s.charAt(i));
            int l = hexToBin(s.charAt(i + 1));
            if (h == -1 || l == -1) {
                return null;    // illegal character
            }
            out[i / 2] = (byte) (h * 16 + l);
        }
        return out;
    }

    public static String toHexBinary(byte[] data) {
        StringBuilder r = new StringBuilder(data.length * 2);
        for (int i = 0; i < data.length; i++) {
            r.append(encode(data[i] >> 4));
            r.append(encode(data[i] & 0xF));
        }
        return r.toString();
    }

    public static char encode(int ch) {
        ch &= 0xF;
        if (ch < 10) {
            return (char) ('0' + ch);
        } else {
            return (char) ('A' + (ch - 10));
        }
    }
}
