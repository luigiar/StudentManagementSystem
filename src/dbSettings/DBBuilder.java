package dbSettings;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.util.PSQLException;

public class DBBuilder {

	private Connection connessione = null;

	public DBBuilder(Connection connessione) {
		this.connessione = connessione;
	}

	public DBBuilder() {
		connessione = null;
	}

//	private boolean connessioneEsistente() {
//		return !(connessione == null);
//	}

	public void creationDatabase(Connection connessione) throws SQLException {
		Statement st = connessione.createStatement();
		try {
			String sql = "CREATE DATABASE db_project";
			st.execute(sql);
			System.out.println("database creato!");
		} catch (PSQLException e) {
			System.out.println("Database già esistente");
		}
	}

	public boolean checkTableExists(String tableName) {
		try {
			DatabaseMetaData metadata = connessione.getMetaData();
			ResultSet tabella = metadata.getTables(null, null, tableName, null);
			if (tabella.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkFunctionExists(String funName) {
		try {
			DatabaseMetaData metadata = connessione.getMetaData();
			ResultSet funzione = metadata.getFunctions(null, null, funName);
			if (funzione.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// Creazione Sequence

	public void sequenceStudente(Connection connessione) {
		try {
			Statement st = connessione.createStatement();

			if (!checkTableExists("studente_id_seq")) {
				String sql = "CREATE SEQUENCE IF NOT EXISTS public.studente_id_seq"
						+ "    INCREMENT 1"
						+ "    START 1"
						+ "    MINVALUE 1"
						+ "    MAXVALUE 9223372036854775807";
				 st.executeUpdate(sql);
				st.close();
			} else {
				System.out.println("La sequence codice studente è già presente!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sequenceCorso(Connection connessione) {
		try {
			Statement st = connessione.createStatement();

			if (!checkTableExists("corso_id_seq")) {
				String sql = "CREATE SEQUENCE IF NOT EXISTS public.corso_id_seq"
						+ "    INCREMENT 1"
						+ "    START 1"
						+ "    MINVALUE 1"
						+ "    MAXVALUE 9223372036854775807";
				st.executeUpdate(sql);
				st.close();
			} else {
				System.out.println("La sequence codice corso è già presente!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sequenceAdmin(Connection connessione) {
		try {
			Statement st = connessione.createStatement();

			if (!checkTableExists("admin_id_seq")) {
				String sql = "CREATE SEQUENCE IF NOT EXISTS public.admin_id_seq"
						+ "    INCREMENT 1"
						+ "    START 1"
						+ "    MINVALUE 1"
						+ "    MAXVALUE 9223372036854775807";
				st.executeUpdate(sql);
				st.close();
			} else {
				System.out.println("La sequence codice admin è già presente!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sequenceAreeTematiche(Connection connessione) {
		try {
			Statement st = connessione.createStatement();

			if (!checkTableExists("aree_tematiche_id_area_seq")) {
				String sql = "CREATE SEQUENCE IF NOT EXISTS public.aree_tematiche_id_area_seq"
						+ "    INCREMENT 1"
						+ "    START 1"
						+ "    MINVALUE 1"
						+ "    MAXVALUE 9223372036854775807";
				st.executeUpdate(sql);
				st.close();
			} else {
				System.out.println("La sequence codice aree tematiche è già presente!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sequenceLezioneCorsoID(Connection connessione) {
		try {
			Statement st = connessione.createStatement();

			if (!checkTableExists("lezione_corso_id_seq")) {
				String sql = "CREATE SEQUENCE IF NOT EXISTS public.lezione_corso_id_seq"
						+ "    INCREMENT 1"
						+ "    START 1"
						+ "    MINVALUE 1"
						+ "    MAXVALUE 9223372036854775807";
				st.executeUpdate(sql);
				st.close();
			} else {
				System.out.println("La sequence codice lezione_corso_id è già presente!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sequenceLezioneID(Connection connessione) {
		try {
			Statement st = connessione.createStatement();

			if (!checkTableExists("lezione_lezione_id_seq")) {
				String sql = "CREATE SEQUENCE IF NOT EXISTS public.lezione_lezione_id_seq"
						+ "    INCREMENT 1"
						+ "    START 1"
						+ "    MINVALUE 1"
						+ "    MAXVALUE 9223372036854775807";
				st.executeUpdate(sql);
				st.close();
			} else {
				System.out.println("La sequence codice lezione_id è già presente!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sequencePartecipazioneCorsoID(Connection connessione) {
		try {
			Statement st = connessione.createStatement();

			if (!checkTableExists("partecipazione_corso_id_seq")) {
				String sql = "CREATE SEQUENCE IF NOT EXISTS public.partecipazione_corso_id_seq"
						+ "    INCREMENT 1"
						+ "    START 1"
						+ "    MINVALUE 1"
						+ "    MAXVALUE 9223372036854775807";
				st.executeUpdate(sql);
				st.close();
			} else {
				System.out.println("La sequence codice partecipazione_corso_id è già presente!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sequencePartecipazioneLezioneID(Connection connessione) {
		try {
			Statement st = connessione.createStatement();

			if (!checkTableExists("partecipazione_id_lezione_seq")) {
				String sql = "CREATE SEQUENCE IF NOT EXISTS public.partecipazione_id_lezione_seq"
						+ "    INCREMENT 1"
						+ "    START 1"
						+ "    MINVALUE 1"
						+ "    MAXVALUE 9223372036854775807";
				st.executeUpdate(sql);
				st.close();
			} else {
				System.out.println("La sequence codice partecipazione_lezione_id è già presente!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sequencePartecipazioneStudenteID(Connection connessione) {
		try {
			Statement st = connessione.createStatement();

			if (!checkTableExists("partecipazione_student_id_seq")) {
				String sql = "CREATE SEQUENCE IF NOT EXISTS public.partecipazione_student_id_seq"
						+ "    INCREMENT 1"
						+ "    START 1"
						+ "    MINVALUE 1"
						+ "    MAXVALUE 9223372036854775807";
				st.executeUpdate(sql);
				st.close();
			} else {
				System.out.println("La sequence codice partecipazione_studente_id è già presente!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sequenceRegistrazioneCorsoID(Connection connessione) {
		try {
			Statement st = connessione.createStatement();

			if (!checkTableExists("registrazione_corso_id_seq")) {
				String sql = "CREATE SEQUENCE IF NOT EXISTS public.registrazione_corso_id_seq"
						+ "    INCREMENT 1"
						+ "    START 1"
						+ "    MINVALUE 1"
						+ "    MAXVALUE 9223372036854775807";
				st.executeUpdate(sql);
				st.close();
			} else {
				System.out.println("La sequence codice registrazione_corso_id è già presente!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sequenceRegistrazioneID(Connection connessione) {
		try {
			Statement st = connessione.createStatement();

			if (!checkTableExists("registrazione_id_registrazione_seq")) {
				String sql = "CREATE SEQUENCE IF NOT EXISTS public.registrazione_id_registrazione_seq"
						+ "    INCREMENT 1"
						+ "    START 1"
						+ "    MINVALUE 1"
						+ "    MAXVALUE 9223372036854775807";
				st.executeUpdate(sql);
				st.close();
			} else {
				System.out.println("La sequence codice registrazione_id è già presente!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sequenceRegistrazioneStudenteID(Connection connessione) {
		try {
			Statement st = connessione.createStatement();

			if (!checkTableExists("registrazione_studente_id_seq")) {
				String sql = "CREATE SEQUENCE IF NOT EXISTS public.registrazione_studente_id_seq"
						+ "    INCREMENT 1"
						+ "    START 1"
						+ "    MINVALUE 1"
						+ "    MAXVALUE 9223372036854775807";
				st.executeUpdate(sql);
				st.close();
			} else {
				System.out.println("La sequence codice registrazione_studente_id è già presente!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Creazione tabelle
	
	public void tableStudente(Connection connessione) {
		try {
			Statement st = connessione.createStatement();
			
			if(!checkTableExists("studente")) {
				String sql = "CREATE TABLE IF NOT EXISTS public.studente"
						+ "("
						+ "    id bigint NOT NULL DEFAULT nextval('studente_id_seq'::regclass),"
						+ "    nome character varying(50) COLLATE pg_catalog.\"default\" NOT NULL,"
						+ "    cognome character varying(50) COLLATE pg_catalog.\"default\" NOT NULL,"
						+ "    data_nascita date NOT NULL,"
						+ "    genere character varying(7) COLLATE pg_catalog.\"default\" NOT NULL,"
						+ "    CONSTRAINT studente_pkey PRIMARY KEY (id)"
						+ ")";
				st.executeUpdate(sql);
			} else {
				System.out.println("La tabella studente è già presente!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void tableCorso(Connection connessione) {
		try {
			Statement st = connessione.createStatement();
			
			if(!checkTableExists("corso")) {
				String sql = "CREATE TABLE IF NOT EXISTS public.corso\r\n"
						+ "("
						+ "    id bigint NOT NULL DEFAULT nextval('corso_id_seq'::regclass),"
						+ "    nome character varying(50) COLLATE pg_catalog.\"default\" NOT NULL,"
						+ "    max_partecipanti integer NOT NULL,"
						+ "    numero_lezioni integer NOT NULL DEFAULT 0,"
						+ "    aree_tematiche character varying(255) COLLATE pg_catalog.\"default\" NOT NULL,"
						+ "    presenze_obbligatorie integer NOT NULL DEFAULT 0,\r\n"
						+ "    descrizione character varying(255) COLLATE pg_catalog.\"default\" NOT NULL,"
						+ "    data_inizio date NOT NULL,"
						+ "    CONSTRAINT corso_pkey1 PRIMARY KEY (id)"
						+ ")";
				st.executeUpdate(sql);
			} else {
				System.out.println("La tabella corso è già presente!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void tableAmministratore(Connection connessione) {
		try {
			Statement st = connessione.createStatement();
			
			if(!checkTableExists("amministratore")) {
				String sql = "CREATE TABLE IF NOT EXISTS public.amministratore"
						+ "("
						+ "    username character varying(50) COLLATE pg_catalog.\"default\" NOT NULL,"
						+ "    password character varying(50) COLLATE pg_catalog.\"default\" NOT NULL,"
						+ "    id bigint NOT NULL DEFAULT nextval('admin_id_seq'::regclass),"
						+ "    CONSTRAINT admin_pkey PRIMARY KEY (id)"
						+ ")";
				st.executeUpdate(sql);
			} else {
				System.out.println("La tabella amministratore è già presente!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void tableAreeTematiche(Connection connessione) {
		try {
			Statement st = connessione.createStatement();
			
			if(!checkTableExists("aree_tematiche")) {
				String sql = "CREATE TABLE IF NOT EXISTS public.aree_tematiche"
						+ "("
						+ "    nome_area character varying COLLATE pg_catalog.\"default\" NOT NULL,"
						+ "    id_area bigint NOT NULL DEFAULT nextval('aree_tematiche_id_area_seq'::regclass),"
						+ "    CONSTRAINT aree_tematiche_pkey PRIMARY KEY (id_area)"
						+ ")";
				st.executeUpdate(sql);
			} else {
				System.out.println("La tabella aree_tematiche è già presente!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void tableAttendance(Connection connessione) {
		try {
			Statement st = connessione.createStatement();
			
			if(!checkTableExists("attendance")) {
				String sql = "CREATE TABLE IF NOT EXISTS public.attendance"
						+ "("
						+ "    id_lezione bigint NOT NULL DEFAULT nextval('partecipazione_id_lezione_seq'::regclass),"
						+ "    corso_id bigint NOT NULL DEFAULT nextval('partecipazione_corso_id_seq'::regclass),"
						+ "    student_id bigint NOT NULL DEFAULT nextval('partecipazione_student_id_seq'::regclass),"
						+ "    presenza boolean NOT NULL DEFAULT false,"
						+ "    CONSTRAINT fk_corso FOREIGN KEY (corso_id)"
						+ "        REFERENCES public.corso (id) MATCH SIMPLE"
						+ "        ON UPDATE NO ACTION"
						+ "        ON DELETE CASCADE"
						+ "        NOT VALID,"
						+ "    CONSTRAINT fk_lezione FOREIGN KEY (id_lezione)"
						+ "        REFERENCES public.lezione (lezione_id) MATCH SIMPLE"
						+ "        ON UPDATE NO ACTION"
						+ "        ON DELETE CASCADE"
						+ "        NOT VALID,"
						+ "    CONSTRAINT fk_studente FOREIGN KEY (student_id)"
						+ "        REFERENCES public.studente (id) MATCH SIMPLE"
						+ "        ON UPDATE NO ACTION"
						+ "        ON DELETE CASCADE"
						+ "        NOT VALID"
						+ ")";
				st.executeUpdate(sql);
			} else {
				System.out.println("La tabella attendance è già presente!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void tableLezione(Connection connessione) {
		try {
			Statement st = connessione.createStatement();
			
			if(!checkTableExists("lezione")) {
				String sql = "CREATE TABLE IF NOT EXISTS public.lezione"
						+ "("
						+ "    data_inizio date NOT NULL,"
						+ "    corso_id bigint NOT NULL DEFAULT nextval('lezione_corso_id_seq'::regclass),"
						+ "    lezione_id bigint NOT NULL DEFAULT nextval('lezione_lezione_id_seq'::regclass),"
						+ "    titolo character varying COLLATE pg_catalog.\"default\" NOT NULL,"
						+ "    descrizione character varying(255) COLLATE pg_catalog.\"default\" NOT NULL,"
						+ "    ora_inizio time without time zone NOT NULL,"
						+ "    durata time without time zone NOT NULL,"
						+ "    CONSTRAINT lezione_pkey PRIMARY KEY (lezione_id),"
						+ "    CONSTRAINT fk_course FOREIGN KEY (corso_id)"
						+ "        REFERENCES public.corso (id) MATCH SIMPLE"
						+ "        ON UPDATE NO ACTION"
						+ "        ON DELETE CASCADE"
						+ "        NOT VALID"
						+ ")\r\n";
				st.executeUpdate(sql);
			} else {
				System.out.println("La tabella lezione è già presente!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void tableRegistrazione(Connection connessione) {
		try {
			Statement st = connessione.createStatement();
			
			if(!checkTableExists("registrazione")) {
				String sql = "CREATE TABLE IF NOT EXISTS public.registrazione"
						+ "("
						+ "    studente_id bigint NOT NULL DEFAULT nextval('registrazione_studente_id_seq'::regclass),"
						+ "    corso_id bigint NOT NULL DEFAULT nextval('registrazione_corso_id_seq'::regclass),"
						+ "    id_registrazione bigint NOT NULL DEFAULT nextval('registrazione_id_registrazione_seq'::regclass),"
						+ "    CONSTRAINT registrazione_pkey PRIMARY KEY (id_registrazione),"
						+ "    CONSTRAINT fk_course FOREIGN KEY (corso_id)"
						+ "        REFERENCES public.corso (id) MATCH SIMPLE"
						+ "        ON UPDATE NO ACTION"
						+ "        ON DELETE CASCADE"
						+ "        NOT VALID,"
						+ "    CONSTRAINT fk_student FOREIGN KEY (studente_id)"
						+ "        REFERENCES public.studente (id) MATCH SIMPLE"
						+ "        ON UPDATE NO ACTION"
						+ "        ON DELETE CASCADE"
						+ "        NOT VALID"
						+ ")";
				st.executeUpdate(sql);
			} else {
				System.out.println("La tabella registrazione è già presente!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Creazione dei Trigger
	
	public void triggerAfterLezioneInsert(Connection connessione) {
		try {
			Statement st = connessione.createStatement();
			
			if(!checkFunctionExists("after_lezione_insert")) {
				String sql = "CREATE OR REPLACE FUNCTION public.after_lezione_insert()\r\n"
						+ "    RETURNS trigger\r\n"
						+ "    LANGUAGE 'plpgsql'\r\n"
						+ "    COST 100\r\n"
						+ "    VOLATILE NOT LEAKPROOF\r\n"
						+ "AS $BODY$\r\n"
						+ "declare\r\n"
						+ "\r\n"
						+ "    studente_id registrazione.studente_id%TYPE;\r\n"
						+ "    cur cursor for \r\n"
						+ "    \r\n"
						+ "    select distinct registrazione.studente_id\r\n"
						+ "	from lezione, registrazione\r\n"
						+ "	where new.corso_id = registrazione.corso_id;\r\n"
						+ " \r\n"
						+ "begin  \r\n"
						+ "    open cur;\r\n"
						+ "    \r\n"
						+ "    fetch next  from cur into studente_id; --assegno i valori dal cursore alla variabile\r\n"
						+ "    while(FOUND) --controllo se i record nel cursore esistono\r\n"
						+ "    loop\r\n"
						+ "	   insert into attendance(id_lezione,corso_id,student_id,presenza) values (new.lezione_id, new.corso_id,studente_id,false);\r\n"
						+ "       fetch next  from cur into studente_id; --prendo il prossimo record dal cursore\r\n"
						+ "    end loop;\r\n"
						+ "    \r\n"
						+ "    close cur;\r\n"
						+ "    \r\n"
						+ "     return new;\r\n"
						+ "end; \r\n"
						+ "$BODY$;"
						+ "CREATE TRIGGER after_lezione_insert\r\n"
						+ "    AFTER INSERT\r\n"
						+ "    ON public.lezione\r\n"
						+ "    FOR EACH ROW\r\n"
						+ "    EXECUTE FUNCTION public.after_lezione_insert();";
				st.executeUpdate(sql);
			} else {
				System.out.println("Trigger after_lezione_insert è già presente!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void triggerAfterRegistrazioneInsert(Connection connessione) {
		try {
			Statement st = connessione.createStatement();
			
			if(!checkFunctionExists("after_registrazione_insert")) {
				String sql = "CREATE OR REPLACE FUNCTION public.after_registrazione_insert()\r\n"
						+ "    RETURNS trigger\r\n"
						+ "    LANGUAGE 'plpgsql'\r\n"
						+ "    COST 100\r\n"
						+ "    VOLATILE NOT LEAKPROOF\r\n"
						+ "AS $BODY$\r\n"
						+ "declare\r\n"
						+ "	\r\n"
						+ "    lezione_id lezione.lezione_id%TYPE;\r\n"
						+ "	\r\n"
						+ "    cur cursor for \r\n"
						+ "    select distinct lezione.lezione_id\r\n"
						+ "	from lezione,registrazione\r\n"
						+ "	where lezione.corso_id = new.corso_id;\r\n"
						+ "	\r\n"
						+ "\r\n"
						+ "begin  \r\n"
						+ "\r\n"
						+ "    open cur;\r\n"
						+ "    \r\n"
						+ "    fetch next  from cur into lezione_id; --assegno i valori dal cursore alla variabile\r\n"
						+ "    while(FOUND) --controllo se i record nel cursore esistono\r\n"
						+ "    loop\r\n"
						+ "	   insert into attendance(id_lezione,corso_id,student_id,presenza) values (lezione_id, new.corso_id,new.studente_id,false);\r\n"
						+ "       fetch next  from cur into lezione_id; --prendo il prossimo record dal cursore\r\n"
						+ "    end loop;\r\n"
						+ "    \r\n"
						+ "    close cur;\r\n"
						+ "    \r\n"
						+ "     return new;\r\n"
						+ "end; \r\n"
						+ "$BODY$;"
						+ "CREATE TRIGGER after_registrazione_insert_trg\r\n"
						+ "    AFTER INSERT\r\n"
						+ "    ON public.registrazione\r\n"
						+ "    FOR EACH ROW\r\n"
						+ "    EXECUTE FUNCTION public.after_registrazione_insert();";
				st.executeUpdate(sql);
			} else {
				System.out.println("Trigger after_registrazione_insert è già presente!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void triggerBeforeAdminRegister(Connection connessione) {
		try {
			Statement st = connessione.createStatement();
			
			if(!checkFunctionExists("before_admin_register")) {
				String sql = "CREATE OR REPLACE FUNCTION public.before_admin_register()\r\n"
						+ "    RETURNS trigger\r\n"
						+ "    LANGUAGE 'plpgsql'\r\n"
						+ "    COST 100\r\n"
						+ "    VOLATILE NOT LEAKPROOF\r\n"
						+ "AS $BODY$\r\n"
						+ "declare \r\n"
						+ "numero_totale_lezioni bigint;\r\n"
						+ "lezioni_presenti bigint;\r\n"
						+ "\r\n"
						+ "begin\r\n"
						+ "\r\n"
						+ "  	if exists(\r\n"
						+ "	  select \r\n"
						+ "	  from amministratore\r\n"
						+ "	  where username ILIKE new.username\r\n"
						+ "	  )then\r\n"
						+ "	  raise warning 'Nome utente già esistente!';\r\n"
						+ "      return null;\r\n"
						+ "	end if;\r\n"
						+ "	\r\n"
						+ "	return new;\r\n"
						+ "end;\r\n"
						+ "$BODY$;"
						+ "CREATE TRIGGER before_admin_register_trg\r\n"
						+ "    BEFORE INSERT\r\n"
						+ "    ON public.amministratore\r\n"
						+ "    FOR EACH ROW\r\n"
						+ "    EXECUTE FUNCTION public.before_admin_register();";
				st.executeUpdate(sql);
			} else {
				System.out.println("Trigger before_admin_register è già presente!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void triggerBeforeIscrizioneStudente(Connection connessione) {
		try {
			Statement st = connessione.createStatement();
			
			if(!checkFunctionExists("before_iscrizione_studente")) {
				String sql = "CREATE OR REPLACE FUNCTION public.before_iscrizione_studente()\r\n"
						+ "    RETURNS trigger\r\n"
						+ "    LANGUAGE 'plpgsql'\r\n"
						+ "    COST 100\r\n"
						+ "    VOLATILE NOT LEAKPROOF\r\n"
						+ "AS $BODY$\r\n"
						+ "declare \r\n"
						+ "numero_totale_studenti bigint;\r\n"
						+ "studenti_presenti bigint;\r\n"
						+ "\r\n"
						+ "begin \r\n"
						+ "	select max_partecipanti\r\n"
						+ "	into numero_totale_studenti\r\n"
						+ "	from corso,registrazione\r\n"
						+ "	where corso.id = new.corso_id;\r\n"
						+ "	\r\n"
						+ "	select distinct count(corso_id)\r\n"
						+ "	into studenti_presenti\r\n"
						+ "	from registrazione\r\n"
						+ "	where new.corso_id = registrazione.corso_id;\r\n"
						+ "\r\n"
						+ "	if(studenti_presenti >= numero_totale_studenti) then\r\n"
						+ "        raise warning 'Non si possono aggiungere più partecipanti, aggiorna il totale';\r\n"
						+ "        return null;\r\n"
						+ "	end if;\r\n"
						+ "    \r\n"
						+ "    return new;\r\n"
						+ "end;\r\n"
						+ "$BODY$;"
						+ "CREATE TRIGGER before_iscrizione_studente_trg\r\n"
						+ "    BEFORE INSERT\r\n"
						+ "    ON public.registrazione\r\n"
						+ "    FOR EACH ROW\r\n"
						+ "    EXECUTE FUNCTION public.before_iscrizione_studente();";
				st.executeUpdate(sql);
			} else {
				System.out.println("Trigger before_iscrizione_studente è già presente!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void triggerBeforeLezioneInsert(Connection connessione) {
		try {
			Statement st = connessione.createStatement();
			
			if(!checkFunctionExists("before_lezione_insert")) {
				String sql = "CREATE OR REPLACE FUNCTION public.before_lezione_insert()\r\n"
						+ "    RETURNS trigger\r\n"
						+ "    LANGUAGE 'plpgsql'\r\n"
						+ "    COST 100\r\n"
						+ "    VOLATILE NOT LEAKPROOF\r\n"
						+ "AS $BODY$\r\n"
						+ "declare \r\n"
						+ "numero_totale_lezioni bigint;\r\n"
						+ "lezioni_presenti bigint;\r\n"
						+ "\r\n"
						+ "begin \r\n"
						+ "	select distinct numero_lezioni\r\n"
						+ "	into numero_totale_lezioni\r\n"
						+ "	from corso,lezione\r\n"
						+ "	where corso.id = new.corso_id;\r\n"
						+ "	\r\n"
						+ "	select distinct count(lezione_id)\r\n"
						+ "	into lezioni_presenti\r\n"
						+ "	from lezione\r\n"
						+ "	where new.corso_id = lezione.corso_id;\r\n"
						+ "\r\n"
						+ "	if(lezioni_presenti >= numero_totale_lezioni) then\r\n"
						+ "        raise warning 'Non si possono aggiungere più lezioni, aggiorna il totale';\r\n"
						+ "        return null;\r\n"
						+ "	end if;\r\n"
						+ "    \r\n"
						+ "    return new;\r\n"
						+ "end;\r\n"
						+ "$BODY$;"
						+ "CREATE TRIGGER before_lezione_insert_trg\r\n"
						+ "    BEFORE INSERT\r\n"
						+ "    ON public.lezione\r\n"
						+ "    FOR EACH ROW\r\n"
						+ "    EXECUTE FUNCTION public.before_lezione_insert()";
				st.executeUpdate(sql);
			} else {
				System.out.println("Trigger before_lezione_insert è già presente!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void triggerBeforeUpdateDateCourse(Connection connessione) {
		try {
			Statement st = connessione.createStatement();
			
			if(!checkFunctionExists("before_update_date_course")) {
				String sql = "CREATE OR REPLACE FUNCTION public.before_update_date_course()\r\n"
						+ "    RETURNS trigger\r\n"
						+ "    LANGUAGE 'plpgsql'\r\n"
						+ "    COST 100\r\n"
						+ "    VOLATILE NOT LEAKPROOF\r\n"
						+ "AS $BODY$\r\n"
						+ "declare \r\n"
						+ "data_prima_lezione_presente date;\r\n"
						+ "\r\n"
						+ "begin \r\n"
						+ "	select min(data_inizio)\r\n"
						+ "	into data_prima_lezione_presente\r\n"
						+ "	from lezione\r\n"
						+ "	where lezione.corso_id = new.id;\r\n"
						+ "	\r\n"
						+ "	if(data_prima_lezione_presente != new.data_inizio) then\r\n"
						+ "        raise warning 'La data di inizio inserita \r\n"
						+ " non corrisponde alla data della prima lezione (%)', data_prima_lezione_presente;\r\n"
						+ "        return null;\r\n"
						+ "	end if;\r\n"
						+ "    \r\n"
						+ "    return new;\r\n"
						+ "end;\r\n"
						+ "$BODY$;"
						+ "CREATE TRIGGER before_update_date_course_trg\r\n"
						+ "    BEFORE UPDATE \r\n"
						+ "    ON public.corso\r\n"
						+ "    FOR EACH ROW\r\n"
						+ "    EXECUTE FUNCTION public.before_update_date_course();";
				st.executeUpdate(sql);
			} else {
				System.out.println("Trigger before_update_date_course è già presente!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void triggerBeforeUpdateMaxPArtecipanti(Connection connessione) {
		try {
			Statement st = connessione.createStatement();
			
			if(!checkFunctionExists("before_update_max_partecipanti")) {
				String sql = "CREATE OR REPLACE FUNCTION public.before_update_max_partecipanti()\r\n"
						+ "    RETURNS trigger\r\n"
						+ "    LANGUAGE 'plpgsql'\r\n"
						+ "    COST 100\r\n"
						+ "    VOLATILE NOT LEAKPROOF\r\n"
						+ "AS $BODY$\r\n"
						+ "declare \r\n"
						+ "numero_totale_studenti bigint;\r\n"
						+ "studenti_presenti bigint;\r\n"
						+ "\r\n"
						+ "begin \r\n"
						+ "	select distinct new.max_partecipanti\r\n"
						+ "	into numero_totale_studenti\r\n"
						+ "	from corso,registrazione\r\n"
						+ "	where new.id = corso_id;\r\n"
						+ "	\r\n"
						+ "	select distinct count(corso_id)\r\n"
						+ "	into studenti_presenti\r\n"
						+ "	from registrazione\r\n"
						+ "	where new.id = registrazione.corso_id;\r\n"
						+ "\r\n"
						+ "	if(studenti_presenti > numero_totale_studenti) then\r\n"
						+ "        raise warning 'Il numero dei partecipanti (%) è maggiore del massimo inserito (%)',studenti_presenti,numero_totale_studenti;\r\n"
						+ "        return null;\r\n"
						+ "	end if;\r\n"
						+ "    \r\n"
						+ "    return new;\r\n"
						+ "end;\r\n"
						+ "$BODY$;"
						+ "CREATE TRIGGER before_update_max_partecipanti_trg\r\n"
						+ "    BEFORE UPDATE \r\n"
						+ "    ON public.corso\r\n"
						+ "    FOR EACH ROW\r\n"
						+ "    EXECUTE FUNCTION public.before_update_max_partecipanti();";
				st.executeUpdate(sql);
			} else {
				System.out.println("Trigger before_update_max_partecipanti è già presente!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void triggerCheckDateFirstLesson(Connection connessione) {
		try {
			Statement st = connessione.createStatement();
			
			if(!checkFunctionExists("check_date_first_lesson")) {
				String sql = "CREATE OR REPLACE FUNCTION public.check_date_first_lesson()\r\n"
						+ "    RETURNS trigger\r\n"
						+ "    LANGUAGE 'plpgsql'\r\n"
						+ "    COST 100\r\n"
						+ "    VOLATILE NOT LEAKPROOF\r\n"
						+ "AS $BODY$\r\n"
						+ "declare \r\n"
						+ "data_inizio_corso date;\r\n"
						+ "lezioni_presenti bigint;\r\n"
						+ "max_data_lezione date;\r\n"
						+ "\r\n"
						+ "begin \r\n"
						+ "\r\n"
						+ "	select distinct count(lezione_id)\r\n"
						+ "	into lezioni_presenti\r\n"
						+ "	from lezione\r\n"
						+ "	where new.corso_id = lezione.corso_id;\r\n"
						+ "	\r\n"
						+ "	select max(lezione.data_inizio)\r\n"
						+ "	into max_data_lezione\r\n"
						+ "	from lezione\r\n"
						+ "	where new.corso_id = lezione.corso_id;\r\n"
						+ "	\r\n"
						+ "	select corso.data_inizio\r\n"
						+ "	into data_inizio_corso\r\n"
						+ "	from corso\r\n"
						+ "	where corso.id = new.corso_id;\r\n"
						+ "\r\n"
						+ "	if(lezioni_presenti = 0 ) then\r\n"
						+ "        if(data_inizio_corso != new.data_inizio) then\r\n"
						+ "		raise warning 'La data di inizio deve corrispondere con la data inizio del corso (%) ', data_inizio_corso;\r\n"
						+ "        return null;\r\n"
						+ "		end if;\r\n"
						+ "	end if;\r\n"
						+ "	\r\n"
						+ "	 if(lezioni_presenti > 0) then\r\n"
						+ "		if(new.data_inizio <= max_data_lezione) then\r\n"
						+ "			raise warning 'Inserita una data precedente all ultima lezione creata (%) ', max_data_lezione;\r\n"
						+ "			return null;\r\n"
						+ "		end if;\r\n"
						+ "	end if;\r\n"
						+ "    \r\n"
						+ "    return new;\r\n"
						+ "end;\r\n"
						+ "$BODY$;"
						+ "CREATE TRIGGER check_date_first_lesson_trg\r\n"
						+ "    BEFORE INSERT\r\n"
						+ "    ON public.lezione\r\n"
						+ "    FOR EACH ROW\r\n"
						+ "    EXECUTE FUNCTION public.check_date_first_lesson();";
				st.executeUpdate(sql);
			} else {
				System.out.println("Trigger check_date_first_lesson è già presente!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void triggerDeleteRegistration(Connection connessione) {
		try {
			Statement st = connessione.createStatement();
			
			if(!checkFunctionExists("delete_registration")) {
				String sql = "CREATE OR REPLACE FUNCTION public.delete_registration()\r\n"
						+ "    RETURNS trigger\r\n"
						+ "    LANGUAGE 'plpgsql'\r\n"
						+ "    COST 100\r\n"
						+ "    VOLATILE NOT LEAKPROOF\r\n"
						+ "AS $BODY$\r\n"
						+ " \r\n"
						+ "begin  \r\n"
						+ "\r\n"
						+ "	delete \r\n"
						+ "	from attendance\r\n"
						+ "	where attendance.corso_id = old.corso_id and student_id = old.studente_id;\r\n"
						+ "	\r\n"
						+ "    return new;\r\n"
						+ "end;\r\n"
						+ "$BODY$;"
						+ "CREATE TRIGGER delete_registration_trg\r\n"
						+ "    AFTER DELETE\r\n"
						+ "    ON public.registrazione\r\n"
						+ "    FOR EACH ROW\r\n"
						+ "    EXECUTE FUNCTION public.delete_registration();";
				st.executeUpdate(sql);
			} else {
				System.out.println("Trigger delete_registration è già presente!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Creazione delle Funzioni
	
	public void functionCheckLogin(Connection connessione) {
		try {
			Statement st = connessione.createStatement();
			
			if(!checkFunctionExists("check_login")) {
				String sql = "CREATE OR REPLACE FUNCTION public.check_login(\r\n"
						+ "	adminuser character varying,\r\n"
						+ "	adminpassword character varying)\r\n"
						+ "    RETURNS boolean\r\n"
						+ "    LANGUAGE 'sql'\r\n"
						+ "    COST 100\r\n"
						+ "    VOLATILE PARALLEL UNSAFE\r\n"
						+ "AS $BODY$\r\n"
						+ " \r\n"
						+ "select exists (select null\r\n"
						+ "			   from amministratore\r\n"
						+ "			   WHERE username = adminuser\r\n"
						+ "			   AND amministratore.password = adminpassword\r\n"
						+ "			   );\r\n"
						+ "$BODY$;";
				st.executeUpdate(sql);
			} else {
				System.out.println("Function check_login è già presente!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void functionCheckNumberLesson(Connection connessione) {
		try {
			Statement st = connessione.createStatement();
			
			if(!checkFunctionExists("check_number_lesson")) {
				String sql = "CREATE OR REPLACE FUNCTION public.check_number_lesson(\r\n"
						+ "	id_course bigint,\r\n"
						+ "	number_lesson bigint)\r\n"
						+ "    RETURNS boolean\r\n"
						+ "    LANGUAGE 'plpgsql'\r\n"
						+ "    COST 100\r\n"
						+ "    VOLATILE PARALLEL UNSAFE\r\n"
						+ "AS $BODY$\r\n"
						+ "\r\n"
						+ "declare \r\n"
						+ "b_value boolean;\r\n"
						+ "lezioni_presenti bigint;\r\n"
						+ "\r\n"
						+ "begin\r\n"
						+ "	\r\n"
						+ "	select count(lezione_id)\r\n"
						+ "	into lezioni_presenti\r\n"
						+ "	from lezione,corso\r\n"
						+ "	where corso.id = id_course and lezione.corso_id = id_course;\r\n"
						+ "	\r\n"
						+ "	if(number_lesson < lezioni_presenti) then\r\n"
						+ "		b_value = false;\r\n"
						+ "		return b_value;\r\n"
						+ "	else\r\n"
						+ "		b_value = true;\r\n"
						+ "		return b_value;\r\n"
						+ "	end if;\r\n"
						+ "\r\n"
						+ "end;\r\n"
						+ "\r\n"
						+ "$BODY$;";
				st.executeUpdate(sql);
			} else {
				System.out.println("Function check_number_lesson è già presente!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void functionDeleteRegisteredCourse(Connection connessione) {
		try {
			Statement st = connessione.createStatement();
			
			if(!checkFunctionExists("delete_registered_course")) {
				String sql = "CREATE OR REPLACE FUNCTION public.delete_registered_course(\r\n"
						+ "	id_course bigint,\r\n"
						+ "	id_student bigint)\r\n"
						+ "    RETURNS void\r\n"
						+ "    LANGUAGE 'sql'\r\n"
						+ "    COST 100\r\n"
						+ "    VOLATILE PARALLEL UNSAFE\r\n"
						+ "AS $BODY$\r\n"
						+ "delete from registrazione \r\n"
						+ "where registrazione.corso_id = id_course and registrazione.studente_id = id_student;\r\n"
						+ "$BODY$;";
				st.executeUpdate(sql);
			} else {
				System.out.println("Function delete_registered_course è già presente!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void functionGetDataTable(Connection connessione) {
		try {
			Statement st = connessione.createStatement();
			
			if(!checkFunctionExists("get_data_table")) {
				String sql = "\r\n"
						+ "CREATE OR REPLACE FUNCTION public.get_data_table(\r\n"
						+ "	id_course bigint,\r\n"
						+ "	date_lesson date,\r\n"
						+ "	id_lesson bigint)\r\n"
						+ "    RETURNS TABLE(idstudente bigint, nome character varying, cognome character varying, data_lezione date, presenza boolean) \r\n"
						+ "    LANGUAGE 'plpgsql'\r\n"
						+ "    COST 100\r\n"
						+ "    VOLATILE PARALLEL UNSAFE\r\n"
						+ "    ROWS 1000\r\n"
						+ "\r\n"
						+ "AS $BODY$\r\n"
						+ "BEGIN\r\n"
						+ "RETURN QUERY\r\n"
						+ "	select distinct attendance.student_id,studente.nome, studente.cognome, lezione.data_inizio,attendance.presenza\r\n"
						+ "	from registrazione join studente on registrazione.studente_id = studente.id,attendance,lezione\r\n"
						+ "	where registrazione.corso_id = id_course and lezione.data_inizio = date_lesson and attendance.student_id = registrazione.studente_id\r\n"
						+ "	and attendance.id_lezione = id_lesson\r\n"
						+ "	order by student_id;\r\n"
						+ "END\r\n"
						+ "$BODY$;";
				st.executeUpdate(sql);
			} else {
				System.out.println("Function get_data_table è già presente!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void functionGetDetailsCourse(Connection connessione) {
		try {
			Statement st = connessione.createStatement();
			
			if(!checkFunctionExists("get_details_course")) {
				String sql = "\r\n"
						+ "CREATE OR REPLACE FUNCTION public.get_details_course(\r\n"
						+ "	)\r\n"
						+ "    RETURNS TABLE(id_corso bigint, nome_corso character varying, massimo_presenze bigint, minimo_presenze bigint, media_presenze numeric, data_lezione date) \r\n"
						+ "    LANGUAGE 'plpgsql'\r\n"
						+ "    COST 100\r\n"
						+ "    VOLATILE PARALLEL UNSAFE\r\n"
						+ "    ROWS 1000\r\n"
						+ "\r\n"
						+ "AS $BODY$\r\n"
						+ "BEGIN\r\n"
						+ "RETURN QUERY\r\n"
						+ "	SELECT distinct id_corsi,nome_corsi, MAX(presenze) as max_presenze, min(presenze) as min_presenze, round(avg(presenze),2) as media_presenti,data_corso\r\n"
						+ "    FROM(SELECT distinct corso.id as id_corsi,corso.nome as nome_corsi,COUNT(case when presenza = false then 1 end) AS assenze, count(case when presenza = true then 1 end) as presenze, corso.data_inizio as data_corso\r\n"
						+ "          FROM attendance join corso on corso.id = attendance.corso_id\r\n"
						+ "	   	  where  presenza = true or presenza = false \r\n"
						+ "	   	  group by id_lezione, corso.nome, corso.data_inizio,corso.id)attendance,corso\r\n"
						+ "  group by nome_corsi,data_corso,id_corsi\r\n"
						+ "  order by id_corsi;\r\n"
						+ "END\r\n"
						+ "$BODY$;";
				st.executeUpdate(sql);
			} else {
				System.out.println("Function get_details_course è già presente!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void functionGetStudentiIdonei(Connection connessione) {
		try {
			Statement st = connessione.createStatement();
			
			if(!checkFunctionExists("get_studenti_idonei")) {
				String sql = "CREATE OR REPLACE FUNCTION public.get_studenti_idonei(\r\n"
						+ "	id_corso bigint)\r\n"
						+ "    RETURNS TABLE(id_studente bigint, nome character varying, cognome character varying, presenze bigint) \r\n"
						+ "    LANGUAGE 'plpgsql'\r\n"
						+ "    COST 100\r\n"
						+ "    VOLATILE PARALLEL UNSAFE\r\n"
						+ "    ROWS 1000\r\n"
						+ "\r\n"
						+ "AS $BODY$\r\n"
						+ "BEGIN\r\n"
						+ "RETURN QUERY\r\n"
						+ "select student_id,studente.nome,studente.cognome, count(*) filter (where presenza)\r\n"
						+ "from attendance join corso on corso.id = corso_id,studente\r\n"
						+ "where corso.id = id_corso and corso_id = id_corso and student_id = studente.id\r\n"
						+ "group by student_id,presenza,presenze_obbligatorie,studente.nome,studente.cognome\r\n"
						+ "having count(*) filter (where presenza) >= presenze_obbligatorie;\r\n"
						+ "END\r\n"
						+ "$BODY$;";
				st.executeUpdate(sql);
			} else {
				System.out.println("Function get_studenti_idonei è già presente!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void functionInsertRegistration(Connection connessione) {
		try {
			Statement st = connessione.createStatement();
			
			if(!checkFunctionExists("insert_registration")) {
				String sql = "CREATE OR REPLACE FUNCTION public.insert_registration(\r\n"
						+ "	c_id bigint,\r\n"
						+ "	s_id bigint)\r\n"
						+ "    RETURNS void\r\n"
						+ "    LANGUAGE 'plpgsql'\r\n"
						+ "    COST 100\r\n"
						+ "    VOLATILE PARALLEL UNSAFE\r\n"
						+ "AS $BODY$\r\n"
						+ "BEGIN\r\n"
						+ "	if exists(select * from registrazione where studente_id = s_id and corso_id = c_id) then\r\n"
						+ "			raise warning 'Studente già registrato al corso!';\r\n"
						+ "	else\r\n"
						+ "			insert into registrazione (studente_id,corso_id) values (s_id,c_id);\r\n"
						+ "	end if;\r\n"
						+ "END \r\n"
						+ "$BODY$;";
				st.executeUpdate(sql);
			} else {
				System.out.println("Function insert_registration è già presente!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void functionShowTableStudentCourse(Connection connessione) {
		try {
			Statement st = connessione.createStatement();
			
			if(!checkFunctionExists("show_table_student_course")) {
				String sql = "CREATE OR REPLACE FUNCTION public.show_table_student_course(\r\n"
						+ "	id_student bigint)\r\n"
						+ "    RETURNS TABLE(id_corso bigint, nome_corso character varying) \r\n"
						+ "    LANGUAGE 'plpgsql'\r\n"
						+ "    COST 100\r\n"
						+ "    VOLATILE PARALLEL UNSAFE\r\n"
						+ "    ROWS 1000\r\n"
						+ "\r\n"
						+ "AS $BODY$\r\n"
						+ "\r\n"
						+ "begin \r\n"
						+ "RETURN QUERY	\r\n"
						+ "		SELECT registrazione.corso_id, corso.nome\r\n"
						+ "		FROM registrazione join corso on corso_id = corso.id\r\n"
						+ "		where studente_id = id_student\r\n"
						+ "		order by corso_id;\r\n"
						+ "end;\r\n"
						+ "$BODY$;";
				st.executeUpdate(sql);
			} else {
				System.out.println("Function show_table_student_course è già presente!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void functionUpdatePresence(Connection connessione) {
		try {
			Statement st = connessione.createStatement();
			
			if(!checkFunctionExists("update_presence")) {
				String sql = "CREATE OR REPLACE FUNCTION public.update_presence(\r\n"
						+ "	id_course bigint,\r\n"
						+ "	studente_id bigint,\r\n"
						+ "	id_lesson bigint,\r\n"
						+ "	presence boolean)\r\n"
						+ "    RETURNS void\r\n"
						+ "    LANGUAGE 'plpgsql'\r\n"
						+ "    COST 100\r\n"
						+ "    VOLATILE PARALLEL UNSAFE\r\n"
						+ "AS $BODY$\r\n"
						+ "BEGIN\r\n"
						+ "	update attendance set presenza = presence\r\n"
						+ "	where id_lezione = id_lesson and corso_id = id_course and student_id = studente_id;\r\n"
						+ "END\r\n"
						+ "$BODY$;";
				st.executeUpdate(sql);
			} else {
				System.out.println("Function update_presence è già presente!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
