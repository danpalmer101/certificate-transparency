/*
 * Copyright (C) 2015 The Android Open Source Project
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

/*
 * Copyright (C) 2018 Daniel Palmer
 *
 * All known logs from https://www.gstatic.com/ct/log_list/all_logs_list.json as of 7th March 2018 added
 */

package org.conscrypt.ct;

import android.util.Base64;

import org.conscrypt.Internal;

/**
 * @hide
 */
@Internal
public final class KnownLogs {
    public static final int LOG_COUNT = 27;
    public static final String[] LOG_DESCRIPTIONS = new String[]{
        "Google 'Argon2018' log",
        "Google 'Argon2019' log",
        "Google 'Argon2020' log",
        "Google 'Argon2021' log",
        "Google 'Aviator' log",
        "Google 'Icarus' log",
        "Google 'Pilot' log",
        "Google 'Rocketeer' log",
        "Google 'Skydiver' log",
        "Cloudflare 'Nimbus2018' Log",
        "Cloudflare 'Nimbus2019' Log",
        "Cloudflare 'Nimbus2020' Log",
        "Cloudflare 'Nimbus2021' Log",
        "DigiCert Log Server",
        "DigiCert Log Server 2",
        "Symantec log",
        "Symantec 'Vega' log",
        "Symantec 'Sirius' log",
        "Certly.IO log",
        "Izenpe log",
        "WoSign log",
        "Venafi log",
        "Venafi Gen2 CT log",
        "CNNIC CT log",
        "StartCom log",
        "Comodo 'Sabre' CT log",
        "Comodo 'Mammoth' CT log"
    };
    public static final String[] LOG_URLS = new String[]{
        "ct.googleapis.com/logs/argon2018/",
        "ct.googleapis.com/logs/argon2019/",
        "ct.googleapis.com/logs/argon2020/",
        "ct.googleapis.com/logs/argon2021/",
        "ct.googleapis.com/aviator/",
        "ct.googleapis.com/icarus/",
        "ct.googleapis.com/pilot/",
        "ct.googleapis.com/rocketeer/",
        "ct.googleapis.com/skydiver/",
        "ct.cloudflare.com/logs/nimbus2018/",
        "ct.cloudflare.com/logs/nimbus2019/",
        "ct.cloudflare.com/logs/nimbus2020/",
        "ct.cloudflare.com/logs/nimbus2021/",
        "ct1.digicert-ct.com/log/",
        "ct2.digicert-ct.com/log/",
        "ct.ws.symantec.com/",
        "vega.ws.symantec.com/",
        "sirius.ws.symantec.com/",
        "log.certly.io/",
        "ct.izenpe.com/",
        "ctlog.wosign.com/",
        "ctlog.api.venafi.com/",
        "ctlog-gen2.api.venafi.com/",
        "ctserver.cnnic.cn/",
        "ct.startssl.com/",
        "sabre.ct.comodo.com/",
        "mammoth.ct.comodo.com/"
    };
    public static final byte[][] LOG_KEYS = new byte[][]{
        Base64.decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE0gBVBa3VR7QZu82V+ynXWD14JM3ORp37MtR"
                + "xTmACJV5ZPtfUA7htQ2hofuigZQs+bnFZkje+qejxoyvk2Q1VaA==", 0),
        Base64.decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEI3MQm+HzXvaYa2mVlhB4zknbtAT8cSxakmB"
                + "oJcBKGqGwYS0bhxSpuvABM1kdBTDpQhXnVdcq+LSiukXJRpGHVg==", 0),
        Base64.decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE6Tx2p1yKY4015NyIYvdrk36es0uAc1zA4PQ"
                + "+TGRY+3ZjUTIYY9Wyu+3q/147JG4vNVKLtDWarZwVqGkg6lAYzA==", 0),
        Base64.decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAETeBmZOrzZKo4xYktx9gI2chEce3cw/tbr5x"
                + "koQlmhB18aKfsxD+MnILgGNl0FOm0eYGilFVi85wLRIOhK8lxKw==", 0),
        Base64.decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE1/TMabLkDpCjiupacAlP7xNi0I1JYP8bQFA"
                + "HDG1xhtolSY1l4QgNRzRrvSe8liE+NPWHdjGxfx3JhTsN9x8/6Q==", 0),
        Base64.decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAETtK8v7MICve56qTHHDhhBOuV4IlUaESxZry"
                + "Cfk9QbG9co/CqPvTsgPDbCpp6oFtyAHwlDhnvr7JijXRD9Cb2FA==", 0),
        Base64.decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEfahLEimAoz2t01p3uMziiLOl/fHTDM0YDOh"
                + "BRuiBARsV4UvxG2LdNgoIGLrtCzWE0J5APC2em4JlvR8EEEFMoA==", 0),
        Base64.decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEIFsYyDzBi7MxCAC/oJBXK7dHjG+1aLCOkHj"
                + "poHPqTyghLpzA9BYbqvnV16mAw04vUjyYASVGJCUoI3ctBcJAeg==", 0),
        Base64.decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEEmyGDvYXsRJsNyXSrYc9DjHsIa2xzb4UR7Z"
                + "xVoV6mrc9iZB7xjI6+NrOiwH+P/xxkRmOFG6Jel20q37hTh58rA==", 0),
        Base64.decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEAsVpWvrH3Ke0VRaMg9ZQoQjb5g/xh1z3DDa"
                + "6IuxY5DyPsk6brlvrUNXZzoIg0DcvFiAn2kd6xmu4Obk5XA/nRg==", 0),
        Base64.decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEkZHz1v5r8a9LmXSMegYZAg4UW+Ug56GtNfJ"
                + "TDNFZuubEJYgWf4FcC5D+ZkYwttXTDSo4OkanG9b3AI4swIQ28g==", 0),
        Base64.decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE01EAhx4o0zPQrXTcYjgCt4MVFsT0Pwjzb1R"
                + "wrM0lhWDlxAYPP6/gyMCXNkOn/7KFsjL7rwk78tHMpY8rXn8AYg==", 0),
        Base64.decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAExpon7ipsqehIeU1bmpog9TFo4Pk8+9oN8OY"
                + "Hl1Q2JGVXnkVFnuuvPgSo2Ep+6vLffNLcmEbxOucz03sFiematg==", 0),
        Base64.decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEAkbFvhu7gkAW6MHSrBlpE1n4+HCFRkC5OLA"
                + "jgqhkTH+/uzSfSl8ois8ZxAD2NgaTZe1M9akhYlrYkes4JECs6A==", 0),
        Base64.decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEzF05L2a4TH/BLgOhNKPoioYCrkoRxvcmaje"
                + "b8Dj4XQmNY+gxa4Zmz3mzJTwe33i0qMVp+rfwgnliQ/bM/oFmhA==", 0),
        Base64.decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEluqsHEYMG1XcDfy1lCdGV0JwOmkY4r87xNu"
                + "roPS2bMBTP01CEDPwWJePa75y9CrsHEKqAy8afig1dpkIPSEUhg==", 0),
        Base64.decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE6pWeAv/u8TNtS4e8zf0ZF2L/lNPQWQc/Ai0"
                + "ckP7IRzA78d0NuBEMXR2G3avTK0Zm+25ltzv9WWis36b4ztIYTQ==", 0),
        Base64.decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEowJkhCK7JewN47zCyYl93UXQ7uYVhY/Z5xc"
                + "bE4Dq7bKFN61qxdglnfr0tPNuFiglN+qjN2Syxwv9UeXBBfQOtQ==", 0),
        Base64.decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAECyPLhWKYYUgEc+tUXfPQB4wtGS2MNvXrjwF"
                + "CCnyYJifBtd2Sk7Cu+Js9DNhMTh35FftHaHu6ZrclnNBKwmbbSA==", 0),
        Base64.decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEJ2Q5DC3cUBj4IQCiDu0s6j51up+TZAkAEcQ"
                + "RF6tczw90rLWXkJMAW7jr9yc92bIKgV8vDXU4lDeZHvYHduDuvg==", 0),
        Base64.decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEzBGIey1my66PTTBmJxklIpMhRrQvAdPG+Sv"
                + " VyLpzmwai8IoCnNBrRhgwhbrpJIsO0VtwKAx+8TpFf1rzgkJgMQ==", 0),
        Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAolpIHxdSlTXLo1s6H1OCdpSj/4D"
                + "yHDc8wLG9wVmLqy1lk9fz4ATVmm+/1iN2Nk8jmctUKK2MFUtlWXZBSpym97M7frGlSaQXUWyA3CqQUE"
                + "uIJOmlEjKTBEiQAvpfDjCHjlV2Be4qTM6jamkJbiWtgnYPhJL6ONaGTiSPm7Byy57iaz/hbckldSOIo"
                + "RhYBiMzeNoA0DiRZ9KmfSeXZ1rB8y8X5urSW+iBzf2SaOfzBvDpcoTuAaWx2DPazoOl28fP1hZ+kHUY"
                + "vxbcMjttjauCFx+JII0dmuZNIwjfeG/GBb9frpSX219k1O4Wi6OEbHEr8at/XQ0y7gTikOxBn/s5wQI"
                + "DAQAB", 0),
        Base64.decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEjicnerZVCXTrbEuUhGW85BXx6lrYfA43zro"
                + "/bAna5ymW00VQb94etBzSg4j/KS/Oqf/fNN51D8DMGA2ULvw3AQ==", 0),
        Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAv7UIYZopMgTTJWPp2IXhhuAf1l6"
                + "a9zM7gBvntj5fLaFm9pVKhKYhVnno94XuXeN8EsDgiSIJIj66FpUGvai5samyetZhLocRuXhAiXXbDN"
                + "yQ4KR51tVebtEq2zT0mT9liTtGwiksFQccyUsaVPhsHq9gJ2IKZdWauVA2Fm5x9h8B9xKn/L/2IaMpk"
                + "IYtd967TNTP/dLPgixN1PLCLaypvurDGSVDsuWabA3FHKWL9z8wr7kBkbdpEhLlg2H+NAC+9nGKx+tQ"
                + "kuhZ/hWR65aX+CNUPy2OB9/u2rNPyDydb988LENXoUcMkQT0dU3aiYGkFAY0uZjD2vH97TM20xYtNQI"
                + "DAQAB", 0),
        Base64.decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAESPNZ8/YFGNPbsu1Gfs/IEbVXsajWTOaft0o"
                + "aFIZDqUiwy1o/PErK38SCFFWa+PeOQFXc9NKv6nV0+05/YIYuUQ==", 0),
        Base64.decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE8m/SiQ8/xfiHHqtls9m7FyOMBg4JVZY9Cgi"
                + "ixXGz0akvKD6DEL8S0ERmFe9U4ZiA0M4kbT5nmuk3I85Sk4bagA==", 0),
        Base64.decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE7+R9dC4VFbbpuyOL+yy14ceAmEf7QGlo/Em"
                + "tYU6DRzwat43f/3swtLr/L8ugFOOt1YU/RFmMjGCL17ixv66MZw==", 0)
    };
}
