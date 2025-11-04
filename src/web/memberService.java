package web;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import dao.memberDAO;
import entities.member;


@Path("/member")
public class memberService {

	// create the dao object because i already have the code talking to my database
	private final memberDAO dao = new memberDAO();
	
	//---------------------READ ALL MEMBERS (GET)----------------------
	@GET
	@Produces("application/xml")
	public List<member> listMembersXML() 
	{
	    return dao.getAllMembers();
	}
	
// -------------GET MEMBER BY ID--------------------
	
	@GET
    @Path("/member/{memberId}")
    @Produces("application/xml")
    public member getMember(@PathParam("memberId")int memberId){
		member m = dao.find(memberId);
		
		return m;
    }
	
	// -----------CREATE NEW MEMBER (POST)-----------------
	@POST
	@Path("/createxml")
	@Consumes("application/xml")
	@Produces("text/plain")
	public String addMemberXML(member m)
	{
		return "Member added " + m.getName();
	}
	
	@POST
	@Path("/createjson")
    @Consumes("application/json")
    public String addJSONMember(member m){
		return "Member added " +m.getName();		
    }
	
	// -----------UPDATE MEMBER (PUT)----------
	@PUT
    @Path("/updateMember/")
    @Produces("application/json")
    public member updateEmployee(member m){
		memberDAO dao = new memberDAO();
		return dao.merge(m);	
    }
	
	// ------------DELETE A MEMBER ( DELETE) ------------
	
	@DELETE
    @Path("/deleteMemebr/{memberId}")
    @Produces("text/plain")
    public String deleteMemberById(@PathParam("memberId")int memberId){
		memberDAO dao = new memberDAO();
		member m = dao.find(memberId);
		dao.remove(m);	
		return "Member "+m+" deleted";
    }
	
	

}










