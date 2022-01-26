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
    class PretDAL
    {
        internal ObservableCollection<Pret> GetAllPret()
        {
            SqlConnection con = DALHelper.Connection;
            try
            {
                SqlCommand cmd = new SqlCommand("GetAllPret", con);
                ObservableCollection<Pret> result = new ObservableCollection<Pret>();
                cmd.CommandType = CommandType.StoredProcedure;
                con.Open();
                SqlDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    Pret p = new Pret();
                    p.PretID = reader.GetInt32(0);
                    p.Valoare = reader.GetInt32(1);
                    p.DataInceput = reader.GetDateTime(2);
                    p.DataFinal = reader.GetDateTime(3);
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
        internal ObservableCollection<Pret> GetAllPretCombo()
        {
            SqlConnection con = DALHelper.Connection;
            try
            {
                SqlCommand cmd = new SqlCommand("GetAllPretCombo", con);
                ObservableCollection<Pret> result = new ObservableCollection<Pret>();
                cmd.CommandType = CommandType.StoredProcedure;
                con.Open();
                SqlDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    Pret p = new Pret();
                    p.PretID = reader.GetInt32(0);
                    p.Valoare = reader.GetInt32(1);
                    p.DataInceput = reader.GetDateTime(2);
                    p.DataFinal = reader.GetDateTime(3);
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
        internal void AddPret(Pret pret)
        {
            using (SqlConnection con = DALHelper.Connection)
            {
                SqlCommand cmd = new SqlCommand("AddPret", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                SqlParameter paramValoare = new SqlParameter("@Valoare", pret.Valoare);
                SqlParameter paramDataInceput = new SqlParameter("@DataInceput", pret.DataInceput);
                SqlParameter paramDescriere = new SqlParameter("@DataFinala", pret.DataFinal);
                SqlParameter paramIdPret = new SqlParameter("@idPret", System.Data.SqlDbType.Int);
                paramIdPret.Direction = System.Data.ParameterDirection.Output;
                cmd.Parameters.Add(paramValoare);
                cmd.Parameters.Add(paramDataInceput);
                cmd.Parameters.Add(paramDescriere);
                cmd.Parameters.Add(paramIdPret);
                con.Open();
                cmd.ExecuteNonQuery();
                if (!String.IsNullOrEmpty(paramIdPret.Value.ToString()))
                    pret.PretID = (int?)paramIdPret.Value;
            }
        }
        internal void DeletePret(Pret pret)
        {
            using (SqlConnection con = DALHelper.Connection)
            {
                SqlCommand cmd = new SqlCommand("DeletePret", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                SqlParameter paramIdPret = new SqlParameter("@idPret", pret.PretID);
                cmd.Parameters.Add(paramIdPret);
                con.Open();
                cmd.ExecuteNonQuery();
            }
        }
        internal void ModityPret(Pret pret)
        {
            using (SqlConnection con = DALHelper.Connection)
            {
                SqlCommand cmd = new SqlCommand("ModifyPret", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                SqlParameter paramIdInterventie = new SqlParameter("@idPret", pret.PretID);
                SqlParameter paramValoare = new SqlParameter("@Valoare", pret.Valoare);
                SqlParameter paramDataInceput = new SqlParameter("@DataInceput", pret.DataInceput);
                SqlParameter paramDescriere = new SqlParameter("@DataFinala", pret.DataFinal);
                cmd.Parameters.Add(paramIdInterventie);
                cmd.Parameters.Add(paramValoare);
                cmd.Parameters.Add(paramDataInceput);
                cmd.Parameters.Add(paramDescriere);
                con.Open();
                cmd.ExecuteNonQuery();
            }
        }
    }
}
