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
    class AccountDAL
    {
        internal ObservableCollection<Account> GetAllAccount()
        {
            SqlConnection con = DALHelper.Connection;
            try
            {
                SqlCommand cmd = new SqlCommand("GetAllAccount", con);
                ObservableCollection<Account> result = new ObservableCollection<Account>();
                cmd.CommandType = CommandType.StoredProcedure;
                con.Open();
                SqlDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    Account p = new Account();
                    p.AccountID = (int)(reader[0]);
                    p.Username = reader.GetString(1);
                    p.Password = reader.GetString(2);
                    p.Role = reader.GetString(3);
                    p.Name = reader.GetString(4);
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
        internal int? GetVenitMedic(int? idMedic)
        {
            SqlConnection con = DALHelper.Connection;
            try
            {
                SqlCommand cmd = new SqlCommand("VenitDoctor", con);
                cmd.CommandType = CommandType.StoredProcedure;
                SqlParameter Usernameparam = new SqlParameter("@idDoctor", SqlDbType.Int);
                Usernameparam.Value = idMedic;
                Usernameparam.Direction = ParameterDirection.Input;
                cmd.Parameters.Add(Usernameparam);
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
        internal ObservableCollection<Account> GetAllDoctors()
        {
            using (SqlConnection con = DALHelper.Connection)
            {
                SqlCommand cmd = new SqlCommand("GetAllDoctors", con);
                ObservableCollection<Account> result = new ObservableCollection<Account>();
                cmd.CommandType = CommandType.StoredProcedure;
                con.Open();
                SqlDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    result.Add(
                        new Account()
                        {
                            AccountID = reader["idAccount"] as int?,
                            Username = reader["Username"].ToString(),
                            Password = reader["Password"].ToString(),
                            Role = reader["Role"].ToString(),
                            Name = reader["Nume"].ToString()
                        }
                    );
                }
                reader.Close();
                return result;
            }
        }

        internal void AddAccount(Account persoana)
        {
            using (SqlConnection con = DALHelper.Connection)
            {
                SqlCommand cmd = new SqlCommand("AddAccount", con);
                cmd.CommandType = CommandType.StoredProcedure;
                SqlParameter Username = new SqlParameter("@Username", persoana.Username);
                SqlParameter Password = new SqlParameter("@Password", persoana.Password);
                SqlParameter Role = new SqlParameter("@Role", persoana.Role);
                SqlParameter Name = new SqlParameter("@Nume", persoana.Name);
                SqlParameter paramIdAccount = new SqlParameter("@idAccount", SqlDbType.Int);
                paramIdAccount.Direction = ParameterDirection.Output;
                cmd.Parameters.Add(Username);
                cmd.Parameters.Add(Password);
                cmd.Parameters.Add(Role);
                cmd.Parameters.Add(Name);
                cmd.Parameters.Add(paramIdAccount);
                con.Open();
                cmd.ExecuteNonQuery();
                persoana.AccountID = paramIdAccount.Value as int?;
            }
        }
        internal Account GetAccount(string Username, string Password)
        {
            SqlConnection con = DALHelper.Connection;
            try
            {
                SqlCommand cmd = new SqlCommand("GetAccount", con);
                cmd.CommandType = CommandType.StoredProcedure;
                SqlParameter Usernameparam = new SqlParameter("@Username", SqlDbType.VarChar);
                Usernameparam.Size = 256;
                SqlParameter Passwordparam = new SqlParameter("@Password", SqlDbType.NVarChar);
                Passwordparam.Size = 256;
                Usernameparam.Value = Username;
                Passwordparam.Value = Password;
                Usernameparam.Direction = ParameterDirection.Input;
                Passwordparam.Direction = ParameterDirection.Input;
                cmd.Parameters.Add(Usernameparam);
                cmd.Parameters.Add(Passwordparam);
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
        internal void DeleteAccount(Account persoana)
        {
            using (SqlConnection con = DALHelper.Connection)
            {
                SqlCommand cmd = new SqlCommand("DeleteAccount", con);
                cmd.CommandType = CommandType.StoredProcedure;
                SqlParameter paramIdPersoana = new SqlParameter("@idAccount", persoana.AccountID);
                cmd.Parameters.Add(paramIdPersoana);
                con.Open();
                cmd.ExecuteNonQuery();
            }
        }

        internal void ModifyAccount(Account persoana)
        {
            using (SqlConnection con = DALHelper.Connection)
            {
                SqlCommand cmd = new SqlCommand("ModifyAccount", con);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                SqlParameter Username = new SqlParameter("@Username", persoana.Username);
                SqlParameter Password = new SqlParameter("@Password", persoana.Password);
                SqlParameter Name = new SqlParameter("@Nume", persoana.Name);
                SqlParameter Role = new SqlParameter("@Role", persoana.Role);
                SqlParameter paramIdAccount = new SqlParameter("@idAccount", persoana.AccountID);
                cmd.Parameters.Add(Username);
                cmd.Parameters.Add(Password);
                cmd.Parameters.Add(Role);
                cmd.Parameters.Add(Name);
                cmd.Parameters.Add(paramIdAccount);
                con.Open();
                cmd.ExecuteNonQuery();
            }
        }
    }
}

