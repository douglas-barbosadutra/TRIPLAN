package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.HotelDTO;
import it.contrader.dto.TagsDTO;
import it.contrader.service.HotelService;


public class HotelServlet extends HttpServlet {

	private final HotelService hotelService = new HotelService();
	private List<HotelDTO> allHotels = new ArrayList<>();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);
		switch (scelta) {

		case "HotelManager":
			allHotels = this.hotelService.getAllHotel();
			request.setAttribute("allHotel", allHotels);
			getServletContext().getRequestDispatcher("/gestorehotel/manageHotel.jsp").forward(request, response);
			break;

		case "insertRedirect":
			response.sendRedirect("gestorehotel/insertHotel.jsp");
			break;

		case "insert":
			final String nommeHotel = request.getParameter("name_hotel");
			final String cityHotel = request.getParameter("city_hotel");
			final int numeroStelle = Integer.parseInt(request.getParameter("numero_stelle"));
			final Double latitude = Double.parseDouble(request.getParameter("latitude"));
			final Double longitude = Double.parseDouble(request.getParameter("longitude"));
			final String gestoreHotel = request.getParameter("gestore_hotel");
			final HotelDTO hotels = new HotelDTO(nommeHotel, cityHotel, numeroStelle, latitude, longitude, gestoreHotel);
			hotelService.insertHotel(hotels);
			showAllHotels(request, response);
			break;

		case "updateRedirect":
			int id = Integer.parseInt(request.getParameter("id"));
			int numerostelleU = Integer.parseInt(request.getParameter("numero_stelle"));
			final Double latitudeU = Double.parseDouble(request.getParameter("latitude"));
			final Double longitudeU = Double.parseDouble(request.getParameter("longitude"));
			HotelDTO hotelUpdate = new HotelDTO("", "", numerostelleU , latitudeU, longitudeU, "");
			hotelUpdate.setIdHotel(id);
			hotelUpdate = (HotelDTO) this.hotelService.readHotel();
			request.setAttribute("placesUpdate", hotelUpdate);
			getServletContext().getRequestDispatcher("/gestorehotel/updateHotel.jsp").forward(request, response);

			break;

		case "update":
			final Integer idUpdate = Integer.parseInt(request.getParameter("idhotel"));
			final String name_hotelUpdate = request.getParameter("name_hotel");
			final String city_hotelUpdate = request.getParameter("city_hotel");
			final Integer numero_stelleUpdate = Integer.parseInt(request.getParameter("numero_stelle"));
			final Double latitudeUpdate = Double.parseDouble(request.getParameter("latitude"));
			final Double longitudeUpdate = Double.parseDouble(request.getParameter("longitude"));
			final String gestore_hotelUpdate = request.getParameter("gestore_hotel");
			final HotelDTO hotel = new HotelDTO(name_hotelUpdate, city_hotelUpdate, numero_stelleUpdate, latitudeUpdate, longitudeUpdate, gestore_hotelUpdate);
			hotel.setIdHotel(idUpdate);
			hotelService.updateHotel(hotel);
			showAllHotels(request, response);
			break;

		case "delete":
			final Integer deleteId = Integer.parseInt(request.getParameter("id"));
			int numerostelleD = Integer.parseInt(request.getParameter("numero_stelle"));
			final Double latitudeD = Double.parseDouble(request.getParameter("latitude"));
			final Double longitudeD = Double.parseDouble(request.getParameter("longitude"));
			final HotelDTO hoteldelete = new HotelDTO("", "", numerostelleD , latitudeD, longitudeD, "");
			hoteldelete.setIdHotel(deleteId);
			hotelService.deleteHotel(deleteId);
			showAllHotels(request, response);
			break;


		case "indietro":
			response.sendRedirect("homeGH.jsp");
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;

		}

	}

	private void showAllHotels(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allHotels = this.hotelService.getAllHotel();
		request.setAttribute("allHotel", allHotels);
		getServletContext().getRequestDispatcher("/gestorehotel/manageHotel.jsp").forward(request, response);
	}
}