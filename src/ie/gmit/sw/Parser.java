package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * The parser class is used to break a text file into kmers and add them to a
 * database.
 * 
 * @author Cormac Raftery
 *
 */
public class Parser implements Runnable {
	private Database db = null;
	private String file;
	private int k;

	public Parser(String file, int k) {
		this.file = file;
		this.k = k;
	}

	public void setDb(Database db) {
		this.db = db;
	}

	/**
	 * Reads from file and breaks entry into the text, and the language. The text
	 * and language should be separated by @
	 */
	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line = null;

			while ((line = br.readLine()) != null) {
				String[] record = line.trim().split("@");

				if (record.length != 2)
					continue;
				{
					parse(record[0], record[1]);
				}
			}

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * After splitting the text from the document into the text and language, this
	 * adds the text to the database in kmers of size k
	 * 
	 * @param text the text that should be broken into kmers
	 * @param lang the language that the text is in
	 */
	private void parse(String text, String lang) {
		Language language = Language.valueOf(lang);

		for (int i = 0; i <= text.length() - k; i++) {
			CharSequence kmer = text.substring(i, i + k);
			db.add(kmer, language);
		}
	}

	public static void main(String[] args) throws Throwable {
		Parser p = new Parser("wili-2018-Small-11750-Edited.txt", 2);
		Database db = new Database();
		p.setDb(db);
		Thread t = new Thread(p);
		t.start();
		t.join();

		db.resize(300);
		String s = "Yiddish";
		String kmerStats = "1032";
		// String s = "Bonjour, comment ca va, c'est francais";
		p.analyseQuery(s);

	}

	/**
	 * after splitting the string to search into kmers of the same size as the db
	 * and converting the kmers to hashcode, search the database for those kmers and
	 * increment a counter for everytime it appears in a language
	 * 
	 * @param s string to search for
	 */
	private void analyseQuery(String s) {
		// Language language = Language.valueOf(k);
		// System.out.println(":::::::::::::"+db.toString()+ ":::::");
		// for(Object x : db.toString().) {

		// }
		// for (int i = 0; i <= s.length() - k; i++) {
		// CharSequence kmer = s.substring(i, i + k);
		// System.out.println(kmer.toString());
		// System.out.println(kmer.hashCode());
		// System.out.println(db.hashCode());

//				if(kmer.hashCode()==(db.hashCode())) {
		// System.out.println("...................."+db.hashCode());
		// System.out.println("Match!");
		// Language lang = Language.Achinese;
		// System.out.println(db.);
		// }
		// db.add(kmer, language);
		// }
		// System.out.println("language is: ");
	}
}
