package com.example.smart_future.smart_parking.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.smart_future.smart_parking.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListDestinationsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListDestinationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListDestinationsFragment extends Fragment {

    public ListDestinationsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Generate view
        View view = inflater.inflate(R.layout.fragment_list_item, container, false);

        // Generate list of destinations
        ArrayList<String> data = new ArrayList<>();
        // #
        data.add("63 South");
        // A
        data.add("All Knight Study (FC-A)");
        data.add("Alpha Delta Pi");
        data.add("Alpha Epsilon Phi");
        data.add("Alpha Tau Omega");
        data.add("Alpha Xi Delta");
        data.add("Ampac");
        data.add("Aquarius Courtyard");
        data.add("Ara Dr. Research Facility");
        data.add("Arboretum");
        data.add("Art Gallery");
        // B
        data.add("Band Storage");
        data.add("Barbara Ying Center");
        data.add("Baseball Field");
        data.add("Bennett Research 2");
        data.add("Bio Molecular Meeting Portable");
        data.add("Biological Sciences");
        data.add("Biological Transgenic Greenhouse");
        data.add("Biology Field Research Center");
        data.add("Biomolecular Research Annex");
        data.add("BPW Scholarship House");
        data.add("Brevard Hall");
        data.add("Burnett Honors College");
        data.add("Burnett House");
        data.add("Burnett School of Biomedical Sciences");
        data.add("Business Administration 1");
        data.add("Business Administration 2");
        // C
        data.add("Career Services and Experiential Learning");
        data.add("Center for Emerging Media");
        data.add("CFE Arena");
        data.add("Challenge Course");
        data.add("Chemistry");
        data.add("Chi Omega");
        data.add("Citrus Hall");
        data.add("Classroom Building 1");
        data.add("Classroom Building 2");
        data.add("Colbourn Hall");
        data.add("College of Arts & Humanities");
        data.add("College of Sciences Building");
        data.add("Counseling and Psychological Services");
        data.add("Creative School 1st Grade");
        data.add("Creative School for Children 1");
        data.add("Creative School Module 2");
        data.add("CREOL");
        // D
        data.add("Delta Delta Delta");
        data.add("Disc Golf Course");
        data.add("Duke Energy UCF Welcome Center");
        // E
        data.add("Early Childhood Center");
        data.add("Eduction");
        data.add("Emergency Operation Center");
        data.add("Emergency Services Training Building");
        data.add("Engine Research Lab");
        data.add("Engineering 1");
        data.add("Engineering 2");
        data.add("Engineering Research Pavilion");
        data.add("Executive Development Center - UCF College of Business");
        // F
        data.add("Facilities and Safety");
        data.add("Fairwinds Alumni Center");
        data.add("Ferrell Commons");
        data.add("FIEA - Florida Interactive Entertainment Academy");
        data.add("Fire Station #62");
        data.add("Flagler Hall");
        data.add("Football Practice Field");
        data.add("Fraternity and Sorority Life");
        // G
        data.add("Gemini Courtyard");
        // H
        data.add("Harris Corporation Engineering Center");
        data.add("Health & Public Affairs 1");
        data.add("Health & Public Affairs 2");
        data.add("Hercules");
        data.add("Housing Administration");
        data.add("Howard Phillips Hall");
        // I
        data.add("IN VIVO Reaserch");
        data.add("Innovative Center");
        data.add("IST Technology Development Center");
        // J
        data.add("Jay Bergman Field - Baseball Stadium");
        data.add("John C. Hitt Library");
        data.add("John T. Washington Center");
        // K
        data.add("Kappa Alpha Theta");
        data.add("Kappa Delta");
        data.add("Kappa Kappa Gamma");
        data.add("Kappa Sigma");
        data.add("Knight's Pantry");
        data.add("Knightro's");
        data.add("Lake Claire");
        data.add("Lake Hall");
        data.add("Leisure Pool");
        data.add("Libra Community Center");
        data.add("Live Oak Ballroom/Garden Room");
        // M
        data.add("Mathematical Sciences Building");
        data.add("Medical Education Building");
        data.add("Memory Mall");
        data.add("Millican Hall");
        data.add("MMAE Facility");
        data.add("Morgridge International Reading Center");
        // N
        data.add("Neptune");
        data.add("Nicholson Fieldhouse");
        data.add("Nicholson School of Communication");
        data.add("Nike");
        // O
        data.add("Office of Student Rights and Responsibilities");
        data.add("Orange Hall");
        data.add("Orlando Tech Center");
        data.add("Osceola Hall");
        // P
        data.add("Parking & Transportation Services");
        data.add("Partnership 1");
        data.add("Partnership 2");
        data.add("Partnership 3");
        data.add("Pegasus Courtyard");
        data.add("Performing Arts Center");
        data.add("Physical Sciences Building");
        data.add("Pi Beta Phi");
        data.add("Polk Hall");
        data.add("Print Shop");
        data.add("Psychology Building");
        data.add("Public Safety Building (Police Station)");
        // R
        data.add("Rec Services Soccer Field Pavilion");
        data.add("Recreation and Wellness Center");
        data.add("Recreation Service Pavilion");
        data.add("Recreation Services Field Maintenance");
        data.add("Recreation Services Field Restroom");
        data.add("Recreation Support");
        data.add("Recycling Center");
        data.add("Reflection Pond");
        data.add("Reflections Kiosk");
        data.add("Rehearsal Hall");
        data.add("Research Pavilion");
        data.add("Retirement Planning & Investments / Athletics");
        data.add("Robinson Observatory");
        data.add("RWC Park");
        // S
        data.add("SDES Information Technology");
        data.add("Seminole Hall");
        data.add("Siemens Energy Center");
        data.add("Sigma Chi");
        data.add("Simulation, Training and Technology Center");
        data.add("Small Business Development Center");
        data.add("Soccer Practice Field");
        data.add("Softball Stadium");
        data.add("Spectrum Stadium");
        data.add("SRC Auditorium");
        data.add("Storm Water Research Lab");
        data.add("Student Accessibility Services");
        data.add("Student Union");
        data.add("Sumter Hall");
        // T
        data.add("Teaching Academy");
        data.add("Technology Commons 1");
        data.add("Technology Commons 2");
        data.add("Technology Incubator");
        data.add("The Venue");
        data.add("Theatre");
        data.add("Timothy R. Newman Nature Pavilion");
        data.add("Tower 1");
        data.add("Tower 2");
        data.add("Tower 3");
        data.add("Tower 4");
        data.add("Track & Soccer Field");
        data.add("Trailer");
        data.add("Trailer 2");
        data.add("Trailer 3");
        data.add("Trailer 4");
        // U
        data.add("UCF Global");
        // V
        data.add("Veteran's Commemorative Site");
        data.add("Visitor and Parking Information Center");
        data.add("Visual Arts Building");
        data.add("Volusia Hall");
        // W
        data.add("Water Tower");
        data.add("Wayne Densch Center");
        data.add("Wayne Densch Sports Center");
        // Z
        data.add("Zeta Tau Alpha");


        // Create Array Adapter to fit list of destinations into fragment
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_list_item_1,
                data);

        ListView lvData = (ListView) view.findViewById(R.id.lvData);
        lvData.setAdapter(adapter);

        // Inflate the layout for this fragment
        return view;
    }
}
