import cv2
from pyzbar.pyzbar import decode
from CallApi import checkIn
import time

cam = cv2.VideoCapture(0)
cam.set(5, 640)
cam.set(6, 480)

camera = True
while camera == True:
    succes, frame = cam.read()

    for i in decode(frame):
        print(i.type)
        print(i.data.decode('utf8'))
        dataCheckIn = i.data.decode('utf8')
        checkinRes = checkIn(dataCheckIn)
        print(checkinRes)
        time.sleep(6)

        cv2.imshow("OurQr_code_scan", frame)
        cv2.waitKey(3)
