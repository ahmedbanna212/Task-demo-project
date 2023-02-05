# Spring Boot RESTful API Project

## Endpoints
the project contains four endpoints which represents  the Tasks main CRUD operations 

* GET  : Retrieve all the tasks with its state  
* POST : Adds a new task and store it   
* PUT  : Updates Task Subject , Description  and task state ( The endpoint can update one of the fields or all of them at the same request based on the sent data ) 
* DELETE : Deletes a task form the database




### POST
 Request URL : `localhost:8080/addTask` <br>
 Request BODY:
 ```json
    {
        "id":"4",
        "description":"descData",
        "subject":"SubjectData"
    }
```

### GET
 Request URL : `localhost:8080/getTask` <br>
 Response BODY:
 ```json
  [
    {
        "task": {
            "id": 4,
            "description": "descData",
            "subject": "SubjectData"
        },
        "taskState": {
            "id": 1,
            "state": "IN_PROGRESS",
            "task_id": 4
        }
    },
    {
        "task": {
            "id": 5,
            "description": "descData",
            "subject": "SubjectData"
        },
        "taskState": {
            "id": 2,
            "state": "IN_PROGRESS",
            "task_id": 5
        }
    }
]
```
### PUT
 Request URL : `localhost:8080/updateTask/{id}` <br>
 Request BODY:
 ```json
    {
        "task": {
            "description": "updated",
            "subject": "subjectUpdated"
        },
        "taskState": {
            "state": "DONE"
        }
    }
```
Note : if there is an attribute  that you don’t want to update , erase it from the Request body like the example below where the task state and subject were erased because description only  where intended to be updated

```json 
    {
        "task": {
            "description": "updated"  
        }
    }
```


### DELETE
 Request URL : `localhost:8080/deleteTask/{id}` <br>
 
