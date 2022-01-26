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
    class InterventieDAL
    {
        internal ObservableCollection<Interventie> GetAllInterventiiDoctor(Account persoana)
        {
            using (SqlConnection connection = DALHelper.Connection)
            {
                ObservableCollection<Interventie> result = new ObservableCollection<Interventie>();
                SqlCommand cmd = new SqlCommand("GetAllInterventiiDoctor", connection);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                SqlParameter paramIdPersoana = new SqlParameter("@idDoctor", persoana.AccountID);
                cmd.Parameters.Add(paramIdPersoana);
                connection.Open();
                SqlDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    result.Add(new Interventie()
                    {
                        InterventieID = reader.GetInt32(0),
                        DoctorID = reader.GetInt32(1),
                        PretID=reader.GetInt32(2),
                        Denumire = reader.GetString(3)
                    });
                }
                return result;
            }
        }
        internal void AddInterventie(Interventie interventie)
        {
            using (SqlConnection con = DALHelper.Connection)
            {
                SqlCommand cmd = new SqlCommand("AddInterventieDoctor", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                SqlParameter paramIdMedic = new SqlParameter("@idDoctor", interventie.DoctorID);
                SqlParameter paramPret = new SqlParameter("@idPret", interventie.PretID);
                SqlParameter paramDescriere = new SqlParameter("@Denumire", interventie.Denumire);
                SqlParameter paramIdInterventie = new SqlParameter("@idInterventie", System.Data.SqlDbType.Int);
                paramIdInterventie.Direction = System.Data.ParameterDirection.Output;
                cmd.Parameters.Add(paramIdMedic);
                cmd.Parameters.Add(paramIdInterventie);
                cmd.Parameters.Add(paramPret);
                cmd.Parameters.Add(paramDescriere);
                con.Open();
                cmd.ExecuteNonQuery();
                if (!String.IsNullOrEmpty(paramIdInterventie.Value.ToString()))
                    interventie.InterventieID = (int?)paramIdInterventie.Value;
            }
        }
        internal ObservableCollection<Interventie> GetInterventiiForDoctor(Account persoana)
        {
            using (SqlConnection connection = DALHelper.Connection)
            {
                ObservableCollection<Interventie> result = new ObservableCollection<Interventie>();
                SqlCommand cmd = new SqlCommand("GetInterventiiForDoctor", connection);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                SqlParameter paramIdPersoana = new SqlParameter("@idAccount", persoana.AccountID);
                cmd.Parameters.Add(paramIdPersoana);
                connection.Open();
                SqlDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    result.Add(new Interventie()
                    {
                        InterventieID = reader.GetInt32(0),
                        DoctorID = reader.GetInt32(1),
                        PretID = reader.GetInt32(2),
                        Denumire = reader.GetString(3)
                    });
                }
                return result;
            }
        }
        internal ObservableCollection<Interventie> GetInterventiiForPret(Pret persoana)
        {
            using (SqlConnection connection = DALHelper.Connection)
            {
                ObservableCollection<Interventie> result = new ObservableCollection<Interventie>();
                SqlCommand cmd = new SqlCommand("GetInterventiiForPret", connection);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                SqlParameter paramIdPersoana = new SqlParameter("@idAccount", persoana.PretID);
                cmd.Parameters.Add(paramIdPersoana);
                connection.Open();
                SqlDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    result.Add(new Interventie()
                    {
                        InterventieID = reader.GetInt32(0),
                        DoctorID = reader.GetInt32(1),
                        PretID = reader.GetInt32(2),
                        Denumire = reader.GetString(3)
                    });
                }
                return result;
            }
        }
        internal Account GetDoctor(int? idMedic)
        {
            SqlConnection con = DALHelper.Connection;
            try
            {
                SqlCommand cmd = new SqlCommand("GetDoctor", con);
                cmd.CommandType = CommandType.StoredProcedure;
                SqlParameter Usernameparam = new SqlParameter("@idMedic", SqlDbType.Int);
                Usernameparam.Value = idMedic;
                Usernameparam.Direction = ParameterDirection.Input;
                cmd.Parameters.Add(Usernameparam);
                Account p = new Account();
                con.Open();
                SqlDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    p.AccountID = reader["idAccount"] as int?;
                    p.Username = reader["Username"].ToString();
                    p.Password = reader["Password"].ToString();
                    p.Role = reader["Role"].ToString();
                    p.Name = reader["Nume"].ToString();
                }
                reader.Close();
                if (p.AccountID == null)
                    return null;
                return p;
            }
            finally
            {
                con.Close();
            }
        }
        internal Pret GetPret(int? idPret)
        {
            SqlConnection con = DALHelper.Connection;
            try
            {
                SqlCommand cmd = new SqlCommand("GetPret", con);
                cmd.CommandType = CommandType.StoredProcedure;
                SqlParameter Usernameparam = new SqlParameter("@idPret", SqlDbType.Int);
                Usernameparam.Value = idPret;
                Usernameparam.Direction = ParameterDirection.Input;
                cmd.Parameters.Add(Usernameparam);
                Pret p = new Pret();
                con.Open();
                SqlDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    p.PretID = reader["idPret"] as int?;
                    p.Valoare = Int32.Parse(reader["valoare"].ToString());
                    p.DataInceput = DateTime.Parse(reader["DataInceput"].ToString());
                    p.DataFinal = DateTime.Parse(reader["DataFinal"].ToString());
                }
                reader.Close();
                if (p.PretID == null)
                    return null;
                return p;
            }
            finally
            {
                con.Close();
            }
        }
        internal void DeleteInterventie(Interventie interventie)
        {
            using (SqlConnection con = DALHelper.Connection)
            {
                SqlCommand cmd = new SqlCommand("DeleteInterventie", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                SqlParameter paramIdInterventie = new SqlParameter("@idInterventie", interventie.InterventieID);
                cmd.Parameters.Add(paramIdInterventie);
                con.Open();
                cmd.ExecuteNonQuery();
            }
        }
        internal void ModifyInterventie(Interventie interventie)
        {
            using (SqlConnection con = DALHelper.Connection)
            {
                SqlCommand cmd = new SqlCommand("ModifyInterventie", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                SqlParameter paramIdInterventie = new SqlParameter("@idInterventie", interventie.InterventieID);
                SqlParameter paramIdMedic = new SqlParameter("@idDoctor", interventie.DoctorID);
                SqlParameter paramPret = new SqlParameter("@idPret", interventie.PretID);
                SqlParameter paramDescriere = new SqlParameter("@Denumire", interventie.Denumire);
                cmd.Parameters.Add(paramIdInterventie);
                cmd.Parameters.Add(paramIdMedic);
                cmd.Parameters.Add(paramPret);
                cmd.Parameters.Add(paramDescriere);
                con.Open();
                cmd.ExecuteNonQuery();
            }
        }
        internal ObservableCollection<Interventie> GetAllInterventii()
        {
            SqlConnection con = DALHelper.Connection;
            try
            {
                SqlCommand cmd = new SqlCommand("GetAllInterventii", con);
                ObservableCollection<Interventie> result = new ObservableCollection<Interventie>();
                cmd.CommandType = CommandType.StoredProcedure;
                con.Open();
                SqlDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    Interventie p = new Interventie();
                    p.InterventieID = (int)(reader[0]);
                    p.DoctorID = (int)(reader[1]);
                    p.PretID = (int)(reader[2]);
                    p.Denumire = reader.GetString(3);
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
    }
}
