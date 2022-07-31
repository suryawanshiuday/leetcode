package com.udays.coding.exercise.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Leetcode problem: 468
 * Problem statement:
 * Given a string queryIP, return "IPv4" if IP is a valid IPv4 address, "IPv6" if IP is a valid IPv6 address or "Neither" if IP is not a correct IP of any type.
 *
 * A valid IPv4 address is an IP in the form "x1.x2.x3.x4" where 0 <= xi <= 255 and xi cannot contain leading zeros. For example, "192.168.1.1" and "192.168.1.0" are valid IPv4 addresses while "192.168.01.1", "192.168.1.00", and "192.168@1.1" are invalid IPv4 addresses.
 *
 * A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where:
 *
 * 1 <= xi.length <= 4
 * xi is a hexadecimal string which may contain digits, lowercase English letter ('a' to 'f') and upper-case English letters ('A' to 'F').
 * Leading zeros are allowed in xi.
 * For example, "2001:0db8:85a3:0000:0000:8a2e:0370:7334" and "2001:db8:85a3:0:0:8A2E:0370:7334" are valid IPv6 addresses, while "2001:0db8:85a3::8A2E:037j:7334" and "02001:0db8:85a3:0000:0000:8a2e:0370:7334" are invalid IPv6 addresses.
 *
 *
 *
 * Example 1:
 *
 * Input: queryIP = "172.16.254.1"
 * Output: "IPv4"
 * Explanation: This is a valid IPv4 address, return "IPv4".
 * Example 2:
 *
 * Input: queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * Output: "IPv6"
 * Explanation: This is a valid IPv6 address, return "IPv6".
 * Example 3:
 *
 * Input: queryIP = "256.256.256.256"
 * Output: "Neither"
 * Explanation: This is neither a IPv4 address nor a IPv6 address.
 *
 *
 * Constraints:
 *
 * queryIP consists only of English letters, digits and the characters '.' and ':'.
 */

public class ValidateIPAddress {

    //Time complexity: O(1) as pattern to match has constant length
    //Space complexity: O(1)

    public String validIPAddress(String queryIP) {

        //IPv4 199.23.17.0
        //can be quoted as chunk.chunk.chunk.chunk
        //which is ^(chunk.)*3+chunk+$
        //^ start, $ end
        //to define chunk, we have 5 cases based on chunk is between 0-255, no leading 0
        //1. single digit > [0-9]
        //2. 2 digits > [1-9][0-9]
        //3. 3 digits > 1[0-9][0-9] or 2[0-4][0-9] or 25[0-5]
        String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        Pattern patternIPv4 = Pattern.compile(
                "^(" + chunkIPv4 + "\\.){3}" +
                        chunkIPv4 + "$"
        );

        //IPv6  2001:0db8:85a3:0000:0000:8a2e:0370:7334
        //can be quoted as chunk.chunk.chunk.chunk.chunk.chunk.chunk.chunk
        //which is ^(chunk:)*7+chunk+$
        //max 4 digits in chunk, contain 0-9, a-f, A-F or leading zeros
        String chunkIPv6 = "([0-9a-fA-F]{1,4})";
        //1,4 is 4 digits max
        //ipv4 chunk can't generalize like this
        Pattern patternIPv6 = Pattern.compile(
                "^(" + chunkIPv6 + "\\:){7}" +
                        chunkIPv6 + "$"
        );

        if(patternIPv4.matcher(queryIP).matches())
            return "IPv4";
        if(patternIPv6.matcher(queryIP).matches())
            return "IPv6";

        return "Neither";

    }

}
