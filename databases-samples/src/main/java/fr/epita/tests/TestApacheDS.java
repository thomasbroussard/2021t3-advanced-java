package fr.epita.tests;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

public class TestApacheDS {

    public static void main(String[] args) throws NamingException {


        //Authentication
        Hashtable<String, String> ldapEnv = new Hashtable<String, String>(11);
        ldapEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");

        ldapEnv.put(Context.PROVIDER_URL, "ldap://localhost:10389");
        ldapEnv.put(Context.SECURITY_AUTHENTICATION, "simple");

        ldapEnv.put(Context.SECURITY_PRINCIPAL, "uid=admin,ou=system");
        ldapEnv.put(Context.SECURITY_CREDENTIALS, "secret");
        DirContext ldapContext = new InitialDirContext(ldapEnv);


        //Search
        SearchControls searchCtls = new SearchControls();

        //Specify the attributes to return
        String returnedAtts[] = {};
        searchCtls.setReturningAttributes(returnedAtts);

        //Specify the search scope
        searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);

        //specify the LDAP search filter
        String searchFilter = "(&(objectClass=inetOrgPerson)(cn=ja*))";

        //Specify the Base for the search
        String searchBase = "ou=marketing,dc=example,dc=com";
        //initialize counter to total the results
        int totalResults = 0;

        // Search for objects using the filter
        NamingEnumeration<SearchResult> answer = ldapContext.search(searchBase, searchFilter, searchCtls);
        answer.asIterator().forEachRemaining(s -> System.out.println(s.getName()));


        ldapContext.close();


    }

}
