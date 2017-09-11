import decimal

def func(x):
	return x**2-13		#function for find root 13

def derivFunc(x):		#Derivative of the above function
	return 2*x

def newtonRaphson(x):	#function to find the root
	h = d(func(x) / derivFunc(x))

	while(abs(h) > 0.00000000000001):	#While h is greater than allowed error ε
		h = d(func(x) / derivFunc(x))

		# x(i+1) = x(i) - f(x) / f'(x)	#Newton Raphson method, formula
		x = d(x) - d(h)
		print("x =", x, ",error =", abs(h))
	return x

d = decimal.Decimal 
x0 = 1.0					#initial guess x0 = 1.0
xFound = newtonRaphson(x0)	# NewtonRaphson Method
print("\nAnswer is:", d(xFound))