Created 3 providers
Created Vehicles:
[0] B-BB 1 (Scooter): Provider: A Bikes, Battery: 100%, UserID: none, Lights:Off
[1] B-BB 2 (Scooter): Provider: B Mobile, Battery: 100%, UserID: none, Lights:Off
[2] B-BB 3 (Tiny Scooter): Provider: C Share, Battery: 100%, UserID: none, Light:Green
[3] Bike B (Bike): Provider: A Bikes, Battery: 100%, UserID: none, Locked:true
Created Users:
0: user1 (0 cents, Standard [Scooter Car ], None)
1: user2 (0 cents, Prepaid [], None)
2: user3 (0 cents, Standard [Scooter ], None)
3: user4 (0 cents, Standard [Car ], None)
--------------
scooter1.reserve(user1):
0: user1 (0 cents, Standard [Scooter Car ], [0] B-BB 1 (Scooter): Provider: A Bikes, Battery: 100%, UserID: 0, Lights:Sidelight)
scooter2.reserve(user1):
Reservation failed.
0: user1 (0 cents, Standard [Scooter Car ], [0] B-BB 1 (Scooter): Provider: A Bikes, Battery: 100%, UserID: 0, Lights:Sidelight)
--------------
scooter1.start(user1):
0: user1 (0 cents, Standard [Scooter Car ], [0] B-BB 1 (Scooter): Provider: A Bikes, Battery: 100%, UserID: 0, Lights:On)
Wait for input...i
scooter1.getCurrentCharge(): 55cents
scooter1.end():
0: user1 (-55 cents, Standard [Scooter Car ], None)
[0] B-BB 1 (Scooter): Provider: A Bikes, Battery: 80%, UserID: none, Lights:Off
--------------
tinyScooter.start(user2):
1: user2 (0 cents, Prepaid [], None)
user2.deposit(1000)
tinyScooter.reserve(user2):
1: user2 (1000 cents, Prepaid [], [2] B-BB 3 (Tiny Scooter): Provider: C Share, Battery: 100%, UserID: 1, Light:Yellow)
tinyScooter.start(user2):
1: user2 (1000 cents, Prepaid [], [2] B-BB 3 (Tiny Scooter): Provider: C Share, Battery: 100%, UserID: 1, Light:Blue)
Wait for input...i
tinyScooter.getCurrentCharge(): 63cents
tinyScooter.end():
1: user2 (937 cents, Prepaid [], None)
[2] B-BB 3 (Tiny Scooter): Provider: C Share, Battery: 86%, UserID: none, Light:Green
--------------
user3.deposit(1000)
bike.start(user3):
2: user3 (1000 cents, Standard [Scooter ], [3] Bike B (Bike): Provider: A Bikes, Battery: 100%, UserID: 2, Locked:false)
Wait for input...i
bike.getCurrentCharge(): 40cents
bike.end():
2: user3 (960 cents, Standard [Scooter ], None)
[3] Bike B (Bike): Provider: A Bikes, Battery: 95%, UserID: none, Locked:true
--------------
car.start(user3)
2: user3 (960 cents, Standard [Scooter ], None)
[4] B-BB 3 (Car): Provider: B Mobile, Battery: 100%, UserID: none, Sidelight: false, Locked:true
car.reserve(user4)
3: user4 (0 cents, Standard [Car ], [4] B-BB 3 (Car): Provider: B Mobile, Battery: 100%, UserID: 3, Sidelight: true, Locked:true)
car.start(user4)
3: user4 (0 cents, Standard [Car ], [4] B-BB 3 (Car): Provider: B Mobile, Battery: 100%, UserID: 3, Sidelight: false, Locked:false)
Wait for input...i
car.getCurrentCharge(): 255cents
car.end():
3: user4 (-255 cents, Standard [Car ], None)
[4] B-BB 3 (Car): Provider: B Mobile, Battery: 0%, UserID: none, Sidelight: false, Locked:true

Process finished with exit code 0
