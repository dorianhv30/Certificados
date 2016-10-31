using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Microsoft.AspNet.Identity;
using System.Security.Claims;
using SIGDAI.Models;
using DataAccess;
using SIGDAI.Helpers;
using Kendo.Mvc.UI;
using Kendo.Mvc.Extensions;

namespace SIGDAI.Controllers
{
    public class RegistroHorasController : Controller
    {
        
        // GET: RegistroHoras
        public ActionResult Inicio()
        {

            ViewData["proyectos"] = GetProyectosAsignado(Helpers.UserInfo.GetUserInfo(Helpers.Constants.ID_USUARIO));
            ViewData["etapas"] = GetEtapasProyectos(Helpers.UserInfo.GetUserInfo(Helpers.Constants.ID_USUARIO));
            return View();
        }
        /// <summary>
        /// Obtiene las etapas para cada proyecto
        /// </summary>
        /// <param name="pIdUsuario">Codigo de colaborador </param>
        /// <returns></returns>
        private IQueryable<EtapasProyectosUsuario> GetEtapasProyectos(string pIdUsuario)
        {
            int vUsuario = int.Parse(pIdUsuario);
            var db = new SIGDAIEntities();
            var vEtapas = from p in db.Proyectos                         
                          join pa in db.ProyectosAsignados on p.IdProyecto equals pa.IdProyecto
                          where pa.IdUsuario == vUsuario
                          select new EtapasProyectosUsuario
                          {
                              IdProyecto = p.IdProyecto,
                              NombreEtapa = pa.EtapasTipoProyectos.Descripcion
                         };
            return vEtapas;
        }
        /// <summary>
        /// Obtiene los proyectos asignados por colaborador
        /// </summary>
        /// <param name="pIdUsuario">Codigo de colaborador </param>
        /// <returns></returns>
        private IQueryable<ProyectosAsignadosViewModel> GetProyectosAsignado(string pIdUsuario)
        {
            int vUsuario = int.Parse(pIdUsuario);
            
            var vProyectos = new SIGDAIEntities().ProyectosAsignados.Select(e => new ProyectosAsignadosViewModel
            {
                IdAsignacion = e.IdAsignacion,
                IdProyecto = e.IdProyecto,
                IdUsuario = e.IdUsuario,
                Estado = e.Estado,
                HorasAsignadas = e.HorasAsignadas,
                NombreProyecto = e.Proyectos.Nombre                
            }).Where(p => p.IdUsuario == vUsuario && p.Estado == Helpers.Constants.ESTADO_ACTIVO);
            return vProyectos;
        }

        private static IQueryable<RegistroHorasViewModel> GetRegistro()
        {
            var db = new SIGDAIEntities();
            var orders = db.RegistroHoras.Select(e => new RegistroHorasViewModel
            {
                IdAsignado = e.IdAsignado,
                ComentarioRechazo = e.ComentarioRechazo,
                Descripcion = e.Descripcion,
                Estado = e.Estado,
                Fecha = e.Fecha,
                Horas = e.Horas,
                HorasAdicionales = e.HorasAdicionales,
                IdEtapa = e.ProyectosAsignados.EtapasTipoProyectos.IdEtapa,
                IdProject = e.IdProject,
                IdProyecto = e.ProyectosAsignados.IdProyecto,
                IdRegistro = e.IdRegistro
            });

            return orders;
        }

        public ActionResult Registro_Read([DataSourceRequest] DataSourceRequest request)
        {
            return Json(GetRegistro().ToDataSourceResult(request), JsonRequestBehavior.AllowGet);
        }

    }
}