# Link para baixar o módulo: https://pypi.org/project/ntplib/
# Rodar o cmd: pip instal ntplib

import ntplib
from time import ctime
import time
from threading import Timer,Thread,Event

class Contador():
   def __init__(self,t,hFunction):
      self.t=t
      self.hFunction = hFunction
      self.thread = Timer(self.t,self.timer)

   def timer(self):
      self.hFunction()
      self.thread = Timer(self.t,self.timer)
      self.thread.start()

   def start(self):
      self.thread.start()

   def cancel(self):
      self.thread.cancel()


def printer():
    c = ntplib.NTPClient()
    response = c.request('pool.ntp.org')
    print('Hora de agora: ',ctime(response.tx_time))

print('NTPclient - Mostra data e hora de 10 em 10 seg')
t = Contador(10, printer)
t.start()
