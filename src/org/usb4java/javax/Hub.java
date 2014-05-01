/*
 * Copyright (C) 2011 Klaus Reimer <k@ailis.de>
 * See LICENSE.md for licensing information.
 */
package org.usb4java.javax;

import java.util.List;
import javax.usb.IUsbDevice;
import javax.usb.IUsbHub;
import javax.usb.IUsbPort;
import javax.usb.exception.UsbPlatformException;
import org.usb4java.Device;

/**
 * usb4java implementation of JSR-80 IUsbHub.
 * <p>
 * @author Klaus Reimer (k@ailis.de)
 */
public final class Hub extends AUsbDevice implements IUsbHub, IUsbPorts {

  /**
   * The hub ports.
   */
  private final Ports ports = new Ports(this);

  /**
   * Constructs a new USB hub device.
   * <p>
   * @param manager  The USB device manager which is responsible for this
   *                 device.
   * @param id       THe device id. Must not be null.
   * @param parentId The parent id. may be null if this device has no parent.
   * @param speed    The device speed.
   * @param device   The libusb device. This reference is only valid during the
   *                 constructor execution, so don't store it in a property or
   *                 something like that.
   * @throws UsbPlatformException When device configuration could not be read.
   */
  public Hub(final DeviceManager manager, final DeviceId id, final DeviceId parentId, final int speed, final Device device) throws UsbPlatformException {
    super(manager, id, parentId, speed, device);
  }

  @Override
  public byte getNumberOfPorts() {
    return this.ports.getNumberOfPorts();
  }

  @Override
  public List<IUsbPort> getUsbPorts() {
    return this.ports.getUsbPorts();
  }

  @Override
  public IUsbPort getUsbPort(final byte number) {
    return this.ports.getUsbPort(number);
  }

  @Override
  public List<IUsbDevice> getAttachedUsbDevices() {
    return this.ports.getAttachedUsbDevices();
  }

  @Override
  public boolean isUsbDeviceAttached(final IUsbDevice device) {
    return this.ports.isUsbDeviceAttached(device);
  }

  @Override
  public boolean isRootUsbHub() {
    return false;
  }

  @Override
  public void connectUsbDevice(final IUsbDevice device) {
    this.ports.connectUsbDevice(device);
  }

  @Override
  public void disconnectUsbDevice(final IUsbDevice device) {
    this.ports.disconnectUsbDevice(device);
  }

  @Override
  public int hashCode() {
    return getId().hashCode();
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    final AUsbDevice other = (AUsbDevice) obj;
    return getId().equals(other.getId());
  }

  @Override
  public boolean isUsbHub() {
    return true;
  }
}
