using CabinetStomatologic.Models;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CabinetStomatologic.DAL
{
    public class PacientDAL
    {
        internal ObservableCollection<Pacient> GetAllPacients()
        {
            SqlConnection con = DALHelper.Connection;
            try
            {
                SqlCommand cmd = new SqlCommand("GetAllPacients", con);
                ObservableCollection<Pacient> result = new ObservableCollection<Pacient>();
                cmd.CommandType = CommandType.StoredProcedure;
                con.Open();
                SqlDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    Pacient p = new Pacient();
                    p.PacientID = (int)(reader[0]);
                    p.Nume = reader.GetString(1);
                    result.Add(p);
                }
                reader.Close();
                return result;
            }
            finally
            {
                con.Close();
            }
        }
        internal ObservableCollection<Pacient> GetAllPacientsMedic(int? idMedic)
        {
            SqlConnection con = DALHelper.Connection;
            try
            {
                SqlCommand cmd = new SqlCommand("GetAllPacientsMedic", con);
                ObservableCollection<Pacient> result = new ObservableCollection<Pacient>();
                cmd.CommandType = CommandType.StoredProcedure;
                SqlParameter Usernameparam = new SqlParameter("@idDoctor", SqlDbType.Int);
                Usernameparam.Value = idMedic;
                Usernameparam.Direction = ParameterDirection.Input;
                cmd.Parameters.Add(Usernameparam);
                con.Open();
                SqlDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    Pacient p = new Pacient();
                    p.PacientID = (int)(reader[0]);
                    p.Nume = reader.GetString(1);
                    result.Add(p);
                }
                reader.Close();
                return result;
            }
            finally
            {
                con.Close();
            }
        }
        internal int? GetCheltuieli(int? idMedic,int? idPacient)
        {
            SqlConnection con = DALHelper.Connection;
            try
            {
                SqlCommand cmd = new SqlCommand("GetProfitPacient", con);
                cmd.CommandType = CommandType.StoredProcedure;
                SqlParameter Usernameparam = new SqlParameter("@idDoctor", SqlDbType.Int);
                SqlParameter Usernameparam1 = new SqlParameter("@idPacient", SqlDbType.Int);
                Usernameparam.Value = idMedic;
                Usernameparam.Direction = ParameterDirection.Input;
                Usernameparam1.Value = idPacient;
                Usernameparam1.Direction = ParameterDirection.Input;
                cmd.Parameters.Add(Usernameparam);
                cmd.Parameters.Add(Usernameparam1);
                con.Open();
                SqlDataReader reader = cmd.ExecuteReader();
                int? venit = 0;
                while (reader.Read())
                {
                    venit = reader[0] as int?;
                }
                reader.Close();
                return venit;
            }
            finally
            {
                con.Close();
            }
        }
        internal void AddPacient(Pacient persoana)
        {
            using (SqlConnection con = DALHelper.Connection)
            {
                SqlCommand cmd = new SqlCommand("AddPacient", con);
                cmd.CommandType = CommandType.StoredProcedure;
                SqlParameter Name = new SqlParameter("@Nume", persoana.Nume);
                SqlParameter paramIdAccount = new SqlParameter("@idPacient", SqlDbType.Int);
                paramIdAccount.Direction = ParameterDirection.Output;
                cmd.Parameters.Add(Name);
                cmd.Parameters.Add(paramIdAccount);
                con.Open();
                cmd.ExecuteNonQuery();
                persoana.PacientID = paramIdAccount.Value as int?;
            }
        }
        internal void DeletePacient(Pacient persoana)
        {
            using (SqlConnection con = DALHelper.Connection)
            {
                SqlCommand cmd = new SqlCommand("DeletePacient", con);
                cmd.CommandType = CommandType.StoredProcedure;
                SqlParameter paramIdPersoana = new SqlParameter("@idPacient", persoana.PacientID);
                cmd.Parameters.Add(paramIdPersoana);
                con.Open();
                cmd.ExecuteNonQuery();
            }
        }

        internal void ModifyPacient(Pacient persoana)
        {
            using (SqlConnection con = DALHelper.Connection)
            {
                SqlCommand cmd = new SqlCommand("ModifyPacient", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                SqlParameter Name = new SqlParameter("@Nume", persoana.Nume);
                SqlParameter paramIdAccount = new SqlParameter("@idPacient", persoana.PacientID);
                cmd.Parameters.Add(Name);
                cmd.Parameters.Add(paramIdAccount);
                con.Open();
                cmd.ExecuteNonQuery();
            }
        }
    }
}
