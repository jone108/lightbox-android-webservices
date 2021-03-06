/**
 * Copyright (c) 2012 Lightbox
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
package com.lightbox.android.utils.debug;

import android.content.Context;
import android.util.Log;

import com.lightbox.android.utils.AndroidUtils;

/** 
 * DebugLog 
 * @author Fabien Devos
 */
public final class DebugLog {
	/** Used to tag logs */
	//@SuppressWarnings("unused")
	private static final String TAG = "DebugLog";
	
    //------------------------------------------------------
    // Private constructor for utility class
    private DebugLog() {
        throw new UnsupportedOperationException("Sorry, you cannot instantiate an utility class!");
    }
    //------------------------------------------------------
	
    private static boolean sLogEnabled = false;
    
    /**
     * Initialize the DebugLog by enabling it if the debuggable attribute is set in the manifest, or disabling it
     * otherwise.
     * @param context
     */
    public static void init(Context context) {
    	sLogEnabled = AndroidUtils.isDebuggable(context);
    	if(sLogEnabled) {
    		Log.w(TAG, "=========================================================================");
    		Log.w(TAG, "= /!\\ Warning: DEBUGGABLE IS TRUE -> DEBUG LOG ENABLED.");
    	}
    }
    
    /**
     * print a {@link Log#DEBUG} log message ONLY if the app is debuggable. Use that instead of the regular Log.d
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param format The format string for the message being logged.
     * @param args Arguments of the format string.
     */
    public static void d(String tag, String format, Object... args) {
        if(sLogEnabled) {
        	format = String.format("LIGHTBOX_DEBUG: %s", format);
        	Log.d(tag, String.format(format, args));
        }
    }
    
    /**
     * print a {@link Log#DEBUG} log message ONLY if the app is debuggable. Use that instead of the regular Log.d
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param text The text for the message being logged.
     * @param args Arguments of the format string.
     */
    public static void d(String tag, String text) {
        if(sLogEnabled) {
        	text = String.format("LIGHTBOX_DEBUG: %s", text);
        	Log.d(tag, text);
        }
    }
}
