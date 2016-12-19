using SIGDAI.DataAccess;
using SIGDAI.Helpers;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Microsoft.AspNet.Identity;

namespace SIGDAI.Controllers
{
    public class HomeController : Controller
    {
        [Authorize]
        public ActionResult Index()
        {
            string vUsuarioActivo;
            string vUsuarioRed, vDominio;
            try
            {
                //Obtiene los datos de usuario                
                vUsuarioActivo = User.Identity.GetUserName();
                

                string[] vDatosUsuario = vUsuarioActivo.Split('\\');
                vDominio = vDatosUsuario[0];
                vUsuarioRed = vDatosUsuario[1];

                //Si se quiere usuar algun usuario especifico para una prueba

                if (bool.Parse(ConfigurationManager.AppSettings["TestUser"]))
                {
                    vDominio = Constantes.TEST_DOMINIO;
                    vUsuarioRed = Constantes.TEST_USUARIO;
                }

                //Valida el usuario en base de datos
                var db = new SIGDAIEntities();
                var vUsuario = db.Usuarios.FirstOrDefault(p => p.Dominio == vDominio && p.UsuarioRed == vUsuarioRed);
                //var vUsuario = from p in db.Usuarios
                //               join ru in db.RolesUsuario on p.IdUsuario equals ru.IdUsuario
                //               where ru.IdUsuario == int.Parse(User.Identity.GetUserId())
                //               select new { Nombre = p.Nombre, PrimerApellido = p.PrimerApellido, SegundoApellido = p.SegundoApellido,
                //                   IdUsuario = p.IdUsuario, Estado = p.Estado, Correo = p.Correo, Rol= ru.Roles.Rol
                //               };

                // Valida si el usuario existe
                if (vUsuario != null)
                {
                    // Valida que el usuario este activo
                    if (vUsuario.Estado == Constantes.ESTADO_ACTIVO)
                    {

                        return View();

                    }
                    else
                    {
                        ViewBag.Error = "Usuario Inactivo";
                        ViewBag.MensajeError = Helpers.Mensajes.USUARIO_INACTIVO;
                        return View("Error");
                    }

                }
                else
                {
                    ViewBag.Error = $"Usuario no Registrado - {vUsuarioActivo};";
                    ViewBag.MensajeError = Helpers.Mensajes.USUARIO_NO_EXISTE;
                    return View("Error");
                }

            }
            catch (Exception e)
            {
                ViewBag.Error = "Error en inicio de sesión";
                ViewBag.MensajeError = $"ha ocurrido un error al iniciar la sesión de usuario {Environment.NewLine} Mensaje: {e.Message} {Environment.NewLine} Excepción: {e.InnerException} {Environment.NewLine} Metodo: ValidateUser";
                return View("Error");

            }
            
        }



        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";

            return View();
        }
        [Authorize (Roles = "APRT")]
        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }
    }
}