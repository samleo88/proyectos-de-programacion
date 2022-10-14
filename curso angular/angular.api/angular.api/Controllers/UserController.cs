using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using angular.api.Models;
using Microsoft.AspNetCore.Mvc;

namespace angular.api.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UserController : ControllerBase
    {


        // GET api/values/5
        [HttpGet("{id}")]
        public ActionResult Get(int id)
        {
            return Ok(new
            {
                nombre = "Pedro",
                apellido = "Perez",
                Email = "Prueba@angular.com"
            });
        }


        // GET api/values/5
        [HttpGet("users")]
        public ActionResult GetUsers()
        {
            List<UserViewModel> users = new List<UserViewModel>();

            users.Add(new UserViewModel {

                Apellido = "gracias",
                Email = "jajajj@gmail.com",
                Nombre = "carlos"
            });

            users.Add(new UserViewModel
            {

                Apellido = "perez",
                Email = "jajajj@gmail.com",
                Nombre = "carla"
            });

            users.Add(new UserViewModel
            {

                Apellido = "garcia",
                Email = "jajajj@gmail.com",
                Nombre = "leonardo"
            });

            users.Add(new UserViewModel
            {

                Apellido = "gonzales",
                Email = "jajajj@gmail.com",
                Nombre = "samil"
            });

            return Ok(users);
        }

        // Post api/values/5
        [HttpPost("adduser")]
        public ActionResult Adduser([FromBody] UserViewModel user)
        {
            return Ok();
        }

    

    }
}
