import socket
import sys

HOST = '192.168.1.15'
PORT = 1026

s=socket.socket(socket.AF_INET,socket.SOCK_STREAM)
s.bind((HOST,PORT))

s.listen(10)

while 1:
	connection,address = s.accept()
	print 'Connected with ' + address[0] + ':' + str(address[1])
	connection.send('Hello Advanced Android Batch !!')
	connection.close()

s.close()
