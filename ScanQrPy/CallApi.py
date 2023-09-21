import requests
from Constant import URL


def checkIn(idUser):
    try:
        dataMutation = 'mutation{createCheckIn(checkInDTO:{idUser:"' + idUser + '",checkIn:true}){id,checkIn,username,dateCheckIn}}'
        return requests.post(URL, json={"query": dataMutation})
    except NameError:
        print("Call api " + URL + " has error " + NameError)
