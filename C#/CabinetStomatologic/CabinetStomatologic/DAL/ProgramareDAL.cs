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
    class ProgramareDAL
    {
        internal ObservableCollection<Programare> GetAllProgramari()
        {
            SqlConnection con = DALHelper.Connection;
            try
            {
                SqlCommand cmd = new SqlCommand("GetAllProgramari", con);
                ObservableCollection<Programare> result = new ObservableCollection<Programare>();
                cmd.CommandType = CommandType.StoredProcedure;
                con.Open();
                SqlDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    Programare p = new Programare();
                    p.ProgramareID = reader.GetInt32(0);
                    p.PacientID = reader.GetInt32(1);
                    p.DataProgramare = reader.GetDateTime(2);
                    p.InterventieID = reader.GetInt32(3);
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
        /*       internal ObservableCollection<Programare> GetProgramareForInterventie(Interventie persoana)
            {
                using (SqlConnection connection = DALHelper.Connection)
                {
                    ObservableCollection<Programare> result = new ObservableCollection<Programare>();
                    SqlCommand cmd = new SqlCommand("GetProgramareForInterventie", connection);
                    cmd.CommandType = System.Data.CommandType.StoredProcedure;
                    SqlParameter paramIdPersoana = new SqlParameter("@idInterventie", persoana.InterventieID);
                    cmd.Parameters.Add(paramIdPersoana);
                    connection.Open();
                    SqlDataReader reader = cmd.ExecuteReader();
                    while (reader.Read())
                    {
                        result.Add(new Programare()
                        {
                            ProgramareID = reader.GetInt32(0),
                            PacientID = reader.GetInt32(1),
                            DataProgramare = reader.GetDateTime(3),
                            InterventieID = reader.GetInt32(4)
                        });
                    }
                    return result;
                }
            }
         internal ObservableCollection<Programare> GetProgramareForPacient(Pacient persoana)
            {
                using (SqlConnection connection = DALHelper.Connection)
                {
                    ObservableCollection<Programare> result = new ObservableCollection<Programare>();
                    SqlCommand cmd = new SqlCommand("GetProgramareForPacient", connection);
                    cmd.CommandType = System.Data.CommandType.StoredProcedure;
                    SqlParameter paramIdPersoana = new SqlParameter("@idPacient", persoana.PacientID);
                    cmd.Parameters.Add(paramIdPersoana);
                    connection.Open();
                    SqlDataReader reader = cmd.ExecuteReader();
                    while (reader.Read())
                    {
                        result.Add(new Programare()
                        {
                            ProgramareID = reader.GetInt32(0),
                            PacientID = reader.GetInt32(1),
                            DataProgramare = reader.GetDateTime(3),
                            InterventieID = reader.GetInt32(4)
                        });
                    }
                    return result;
                }
            }*/
        internal Pacient GetPacient(int? idPret)
        {
            SqlConnection con = DALHelper.Connection;
            try
            {
                SqlCommand cmd = new SqlCommand("GetPacient", con);
                cmd.CommandType = CommandType.StoredProcedure;
                SqlParameter Usernameparam = new SqlParameter("@idPacient", SqlDbType.Int);
                Usernameparam.Value = idPret;
                Usernameparam.Direction = ParameterDirection.Input;
                cmd.Parameters.Add(Usernameparam);
                Pacient p = new Pacient();
                con.Open();
                SqlDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    p.PacientID = reader["idPacient"] as int?;
                    p.Nume = reader["Nume"].ToString();
                }
                reader.Close();
                if (p.PacientID == null)
                    return null;
                return p;
            }
            finally
            {
                con.Close();
            }
        }
        internal Interventie GetInterventie(int? idPret)
        {
            SqlConnection con = DALHelper.Connection;
            try
            {
                SqlCommand cmd = new SqlCommand("GetInterventie", con);
                cmd.CommandType = CommandType.StoredProcedure;
                SqlParameter Usernameparam = new SqlParameter("@idInterventie", SqlDbType.Int);
                Usernameparam.Value = idPret;
                Usernameparam.Direction = ParameterDirection.Input;
                cmd.Parameters.Add(Usernameparam);
                Interventie p = new Interventie();
                con.Open();
                SqlDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    p.InterventieID = reader["idPret"] as int?;
                    p.DoctorID = Int32.Parse(reader["idMedic"].ToString());
                    p.PretID = Int32.Parse(reader["idPret"].ToString());
                    p.Denumire = reader["denumire"].ToString();
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
        internal ObservableCollection<Programare> GetAllProgramariDoctor(Account persoana)
        {
            using (SqlConnection connection = DALHelper.Connection)
            {
                ObservableCollection<Programare> result = new ObservableCollection<Programare>();
                SqlCommand cmd = new SqlCommand("GetAllProgramariMedic", connection);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                SqlParameter paramIdPersoana = new SqlParameter("@idDoctor", persoana.AccountID);
                cmd.Parameters.Add(paramIdPersoana);
                connection.Open();
                SqlDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    result.Add(new Programare()
                    {
                        ProgramareID = reader.GetInt32(0),
                        PacientID = reader.GetInt32(1),
                        DataProgramare = reader.GetDateTime(2),
                        InterventieID = reader.GetInt32(3)
                    });
                }
                return result;
            }
        }
        internal ObservableCollection<Programare> GetProgramariForPerson(Pacient persoana)
        {
            using (SqlConnection connection = DALHelper.Connection)
            {
                ObservableCollection<Programare> result = new ObservableCollection<Programare>();
                SqlCommand cmd = new SqlCommand("GetProgramariForPerson", connection);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                SqlParameter paramIdPersoana = new SqlParameter("@idPersoana", persoana.PacientID);
                cmd.Parameters.Add(paramIdPersoana);
                connection.Open();
                SqlDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    result.Add(new Programare()
                    {
                        ProgramareID = reader.GetInt32(0),
                        PacientID = reader.GetInt32(1),
                        DataProgramare = reader.GetDateTime(2),
                        InterventieID = reader.GetInt32(3)
                    });
                }
                return result;
            }
        }
        internal void AddProgramare(Programare prog)
        {
            using (SqlConnection con = DALHelper.Connection)
            {
                SqlCommand cmd = new SqlCommand("AddProgramare", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                SqlParameter paramPacient = new SqlParameter("@idPacient", prog.PacientID);
                SqlParameter paramInterventie = new SqlParameter("@idInterventie", prog.InterventieID);
                SqlParameter paramDescriere = new SqlParameter("@DataProgramare", prog.DataProgramare);
                SqlParameter paramIdProgramare = new SqlParameter("@idProgramare", System.Data.SqlDbType.Int);
                paramIdProgramare.Direction = System.Data.ParameterDirection.Output;
                cmd.Parameters.Add(paramPacient);
                cmd.Parameters.Add(paramIdProgramare);
                cmd.Parameters.Add(paramDescriere);
                cmd.Parameters.Add(paramInterventie);
                con.Open();
                cmd.ExecuteNonQuery();
                if (!String.IsNullOrEmpty(paramIdProgramare.Value.ToString()))
                    prog.ProgramareID = (int?)paramIdProgramare.Value;
            }
        }
        internal void DeleteProgramare(Programare prog)
        {
            using (SqlConnection con = DALHelper.Connection)
            {
                SqlCommand cmd = new SqlCommand("DeleteProgramare", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                SqlParameter paramIdProgramare = new SqlParameter("@idProgramare", prog.ProgramareID);
                cmd.Parameters.Add(paramIdProgramare);
                con.Open();
                cmd.ExecuteNonQuery();
            }
        }
        internal void ModityProgramare(Programare programare)
        {
            using (SqlConnection con = DALHelper.Connection)
            {
                SqlCommand cmd = new SqlCommand("ModifyProgramare", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                SqlParameter paramIdInterventie = new SqlParameter("@idInterventie", programare.InterventieID);
                SqlParameter paramIdProg = new SqlParameter("@idProgramare", programare.ProgramareID);
                SqlParameter paramIdMedic = new SqlParameter("@idPacient", programare.PacientID);
                SqlParameter paramPret = new SqlParameter("@DataProgramare", programare.DataProgramare);
                cmd.Parameters.Add(paramIdProg);
                cmd.Parameters.Add(paramIdMedic);
                cmd.Parameters.Add(paramIdInterventie);
                cmd.Parameters.Add(paramPret);
                con.Open();
                cmd.ExecuteNonQuery();
            }
        }
    }
}
