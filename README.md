### Domain Class : Tenant
Tenant domain class contains bare minimum properties like : <br>
`Integer id  : primary key` <br>
`String name : not null field` <br>
`String address` <br>
`LocalDateTime joinedDate` <br>
`Boolean active : denoting active status of tenant` <br>

### API Endpoints

| HTTP Verbs | Endpoints | Action |
| --- | --- | --- |
| POST | /api/tenants/ | To add a new Tenant |
| GET | /api/tenants/ | To retrieve all tenants on the platform |
| GET | /api/tenants/:tenantId | To retrieve details of a single Tenant |
| GET | /api/tenants/active | To retrieve List of tenant who are active on platform |
| PUT | /api/tenants/update/:tenantId | To edit the details of a single cause |
| DELETE | /api/tenants/delete/:tenantId | To delete a single Tenant |
| PUT | /api/tenants/update/:tenantId | To edit the details of a single cause |
| PUT | /api/tenants/:tenantId/activate | To activate the status of Tenant |
| PUT | /api/tenants/:tenantId/deactivate | To deactivate the status of Tenant |

## Actual endpoints
http://localhost:8080/api/tenants/ <br>
http://localhost:8080/api/tenants/1 <br>
http://localhost:8080/api/tenants/update/1 <br>
http://localhost:8080/api/tenants/delete/1 <br>
http://localhost:8080/api/tenants/active <br>
http://localhost:8080/api/tenants/{id}/activate <br>
http://localhost:8080/api/tenants/{id}/deactivate <br>
@ExceptionHandler(TenantNotFoundException.class)
@ResponseStatus(HttpStatus.NOT_FOUND)
@ResponseBody
## My Findings
* In order to implement toggle function of active status, `@Modifying` in conjunction with 
`@Path("name")` and `@Transactional` was used.
* To create our own error handlers `@ControllerAdvice`, <br>
  `@ExceptionHandler(CustomExceptionType.class)`
  `@ResponseStatus(HttpStatus.NOT_FOUND)` can be used.

