# clientAPI
API with two services, "create order" and "consult order".

Deployed on Wildfly 11.

WebServices:
'''
//http://hostname:port/order-web/rest/api/createOrder
//http://hostname:port/order-web/rest/api/searchOrder
//http://hostname:port/order-web/rest/api/listClient
//http://hostname:port/order-web/rest/api/searchClient
//http://hostname:port/order-web/rest/api/get
'''

-search, list and create are post methods, despite list method, use the following XML to call the methods (can use JSON instead).

--createOrder:
'''
<orderList>
<order>
	<controlId>1</controlId>
  <!-- OPTIONAL -->
  <date>10/01/2018</date>
  <productName>Name</productName>
  <productValue>10.00</productValue>
  <!-- OPTIONAL -->
  <productQuantity>1</productQuantity>
	<client>
		<id>1</id>
	</client>
</order>
<order>
	<controlId>2</controlId>
  <!-- OPTIONAL -->
  <date>11/01/2018</date>
  <productName>Name</productName>
  <productValue>15.00</productValue>
  <!-- OPTIONAL -->
  <productQuantity>2</productQuantity>
	<client>
		<id>2</id>
	</client>
</order>
</orderList>
'''

--searchOrder:
'''
<order>
  <!-- OPTIONAL -->
	<controlId>1</controlId>
  <!-- OPTIONAL -->
  <date>10/01/2018</date>
  <!-- OPTIONAL -->
  <productName>Name</productName>
  <!-- OPTIONAL -->
  <productValue>10.00</productValue>
  <!-- OPTIONAL -->
  <productQuantity>1</productQuantity>
  <!-- OPTIONAL -->
  <totalValue>10.00</totalValue>
  <!-- OPTIONAL -->
	<client>
    <!-- OPTIONAL -->
		<id>1</id>
    <!-- OPTIONAL -->
    <name>Name</name>
	</client>
</order>
'''

--searchClient:
'''
<client>
  <!-- OPTIONAL -->
	<id>1</id>
  <!-- OPTIONAL -->
  <name>Name</name>
</client>
'''
