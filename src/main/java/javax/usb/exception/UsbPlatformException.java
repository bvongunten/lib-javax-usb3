/**
 * Original Copyright (c) 1999 - 2001, International Business Machines
 * Corporation. All Rights Reserved. Provided and licensed under the terms and
 * conditions of the Common Public License:
 * http://oss.software.ibm.com/developerworks/opensource/license-cpl.html
 * <p>
 * Modifications and improvements Copyright (c) 2014 Key Bridge Global LLC. All
 * Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package javax.usb.exception;

/**
 * Exception indicating a platform-specific UsbException.
 * <p>
 * This indicates an error occurred that is specific to the operating system or
 * platform. This provides access to the specific
 * {@link #getErrorCode() error code} and/or
 * {@link #getPlatformException() platform Exception}.
 * <p>
 * @author Dan Streetman
 */
public class UsbPlatformException extends UsbException {

  private static final long serialVersionUID = 1L;

  private Exception platformException = null;
  private int errorCode = 0;

  /**
   * Constructor.
   */
  public UsbPlatformException() {
    super();
  }

  /**
   * Constructor.
   * <p>
   * @param s The detail message.
   */
  public UsbPlatformException(String s) {
    super(s);
  }

  /**
   * Constructor.
   * <p>
   * @param e The error code.
   */
  public UsbPlatformException(int e) {
    super();
    errorCode = e;
  }

  /**
   * Constructor.
   * <p>
   * @param pE The platform Exception.
   */
  public UsbPlatformException(Exception pE) {
    super();
    platformException = pE;
  }

  /**
   * Constructor.
   * <p>
   * @param s The detail message.
   * @param e The error code.
   */
  public UsbPlatformException(String s, int e) {
    super(s);
    errorCode = e;
  }

  /**
   * Constructor.
   * <p>
   * @param s  The detail message.
   * @param pE The platform Exception.
   */
  public UsbPlatformException(String s, Exception pE) {
    super(s);
    platformException = pE;
  }

  /**
   * Constructor.
   * <p>
   * @param e  The error code.
   * @param pE The platform Exception.
   */
  public UsbPlatformException(int e, Exception pE) {
    super();
    errorCode = e;
    platformException = pE;
  }

  /**
   * Constructor.
   * <p>
   * @param s  The detail message.
   * @param e  The error code.
   * @param pE The platform Exception.
   */
  public UsbPlatformException(String s, int e, Exception pE) {
    super(s);
    errorCode = e;
    platformException = pE;
  }

  /**
   * Get the platform Exception.
   * <p>
   * @return The platform Exception, or null.
   */
  public Exception getPlatformException() {
    return platformException;
  }

  /**
   * Get the platform error code.
   * <p>
   * @return The platform error code.
   */
  public int getErrorCode() {
    return errorCode;
  }

}