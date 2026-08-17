package com.AI_investigator.model;

import com.AI_investigator.dto.enums.DepartureSectorEnum;
import com.AI_investigator.dto.enums.DestinationSectorEnum;
import com.AI_investigator.seeder.FlightDataSeeder.FlightRoute;

import java.util.List;

public final class FlightRoutes {

    private FlightRoutes() {
    }

    public static final List<FlightRoute> ROUTES = List.of(

            // =========================
            // DELHI
            // =========================

            new FlightRoute(DepartureSectorEnum.DEL, DestinationSectorEnum.BOM),
            new FlightRoute(DepartureSectorEnum.DEL, DestinationSectorEnum.BLR),
            new FlightRoute(DepartureSectorEnum.DEL, DestinationSectorEnum.HYD),
            new FlightRoute(DepartureSectorEnum.DEL, DestinationSectorEnum.MAA),
            new FlightRoute(DepartureSectorEnum.DEL, DestinationSectorEnum.CCU),
            new FlightRoute(DepartureSectorEnum.DEL, DestinationSectorEnum.PNQ),
            new FlightRoute(DepartureSectorEnum.DEL, DestinationSectorEnum.AMD),
            new FlightRoute(DepartureSectorEnum.DEL, DestinationSectorEnum.JAI),
            new FlightRoute(DepartureSectorEnum.DEL, DestinationSectorEnum.LKO),
            new FlightRoute(DepartureSectorEnum.DEL, DestinationSectorEnum.GOI),
            new FlightRoute(DepartureSectorEnum.DEL, DestinationSectorEnum.GOX),
            new FlightRoute(DepartureSectorEnum.DEL, DestinationSectorEnum.COK),
            new FlightRoute(DepartureSectorEnum.DEL, DestinationSectorEnum.SXR),
            new FlightRoute(DepartureSectorEnum.DEL, DestinationSectorEnum.IXC),
            new FlightRoute(DepartureSectorEnum.DEL, DestinationSectorEnum.GAU),
            new FlightRoute(DepartureSectorEnum.DEL, DestinationSectorEnum.VNS),
            new FlightRoute(DepartureSectorEnum.DEL, DestinationSectorEnum.DXB),
            new FlightRoute(DepartureSectorEnum.DEL, DestinationSectorEnum.SIN),

            // =========================
            // MUMBAI
            // =========================

            new FlightRoute(DepartureSectorEnum.BOM, DestinationSectorEnum.DEL),
            new FlightRoute(DepartureSectorEnum.BOM, DestinationSectorEnum.BLR),
            new FlightRoute(DepartureSectorEnum.BOM, DestinationSectorEnum.HYD),
            new FlightRoute(DepartureSectorEnum.BOM, DestinationSectorEnum.MAA),
            new FlightRoute(DepartureSectorEnum.BOM, DestinationSectorEnum.CCU),
            new FlightRoute(DepartureSectorEnum.BOM, DestinationSectorEnum.AMD),
            new FlightRoute(DepartureSectorEnum.BOM, DestinationSectorEnum.GOI),
            new FlightRoute(DepartureSectorEnum.BOM, DestinationSectorEnum.GOX),
            new FlightRoute(DepartureSectorEnum.BOM, DestinationSectorEnum.COK),
            new FlightRoute(DepartureSectorEnum.BOM, DestinationSectorEnum.DXB),

            // =========================
            // BANGALORE
            // =========================

            new FlightRoute(DepartureSectorEnum.BLR, DestinationSectorEnum.DEL),
            new FlightRoute(DepartureSectorEnum.BLR, DestinationSectorEnum.BOM),
            new FlightRoute(DepartureSectorEnum.BLR, DestinationSectorEnum.HYD),
            new FlightRoute(DepartureSectorEnum.BLR, DestinationSectorEnum.MAA),
            new FlightRoute(DepartureSectorEnum.BLR, DestinationSectorEnum.CCU),
            new FlightRoute(DepartureSectorEnum.BLR, DestinationSectorEnum.COK),
            new FlightRoute(DepartureSectorEnum.BLR, DestinationSectorEnum.GOI),
            new FlightRoute(DepartureSectorEnum.BLR, DestinationSectorEnum.DXB),
            new FlightRoute(DepartureSectorEnum.BLR, DestinationSectorEnum.SIN),

            // =========================
            // HYDERABAD
            // =========================

            new FlightRoute(DepartureSectorEnum.HYD, DestinationSectorEnum.DEL),
            new FlightRoute(DepartureSectorEnum.HYD, DestinationSectorEnum.BOM),
            new FlightRoute(DepartureSectorEnum.HYD, DestinationSectorEnum.BLR),
            new FlightRoute(DepartureSectorEnum.HYD, DestinationSectorEnum.MAA),
            new FlightRoute(DepartureSectorEnum.HYD, DestinationSectorEnum.CCU),
            new FlightRoute(DepartureSectorEnum.HYD, DestinationSectorEnum.COK),
            new FlightRoute(DepartureSectorEnum.HYD, DestinationSectorEnum.DXB),

            // =========================
            // CHENNAI
            // =========================

            new FlightRoute(DepartureSectorEnum.MAA, DestinationSectorEnum.DEL),
            new FlightRoute(DepartureSectorEnum.MAA, DestinationSectorEnum.BOM),
            new FlightRoute(DepartureSectorEnum.MAA, DestinationSectorEnum.BLR),
            new FlightRoute(DepartureSectorEnum.MAA, DestinationSectorEnum.HYD),
            new FlightRoute(DepartureSectorEnum.MAA, DestinationSectorEnum.CCU),
            new FlightRoute(DepartureSectorEnum.MAA, DestinationSectorEnum.COK),
            new FlightRoute(DepartureSectorEnum.MAA, DestinationSectorEnum.SIN),
            new FlightRoute(DepartureSectorEnum.MAA, DestinationSectorEnum.DXB),

            // =========================
            // KOLKATA
            // =========================

            new FlightRoute(DepartureSectorEnum.CCU, DestinationSectorEnum.DEL),
            new FlightRoute(DepartureSectorEnum.CCU, DestinationSectorEnum.BOM),
            new FlightRoute(DepartureSectorEnum.CCU, DestinationSectorEnum.BLR),
            new FlightRoute(DepartureSectorEnum.CCU, DestinationSectorEnum.MAA),
            new FlightRoute(DepartureSectorEnum.CCU, DestinationSectorEnum.HYD),
            new FlightRoute(DepartureSectorEnum.CCU, DestinationSectorEnum.GAU),

            // =========================
            // DUBAI
            // =========================

            new FlightRoute(DepartureSectorEnum.DXB, DestinationSectorEnum.DEL),
            new FlightRoute(DepartureSectorEnum.DXB, DestinationSectorEnum.BOM),
            new FlightRoute(DepartureSectorEnum.DXB, DestinationSectorEnum.BLR),
            new FlightRoute(DepartureSectorEnum.DXB, DestinationSectorEnum.HYD),
            new FlightRoute(DepartureSectorEnum.DXB, DestinationSectorEnum.MAA),
            new FlightRoute(DepartureSectorEnum.DXB, DestinationSectorEnum.CCU),
            new FlightRoute(DepartureSectorEnum.DXB, DestinationSectorEnum.SIN),

            // =========================
            // SINGAPORE
            // =========================

            new FlightRoute(DepartureSectorEnum.SIN, DestinationSectorEnum.DEL),
            new FlightRoute(DepartureSectorEnum.SIN, DestinationSectorEnum.BOM),
            new FlightRoute(DepartureSectorEnum.SIN, DestinationSectorEnum.BLR),
            new FlightRoute(DepartureSectorEnum.SIN, DestinationSectorEnum.MAA),
            new FlightRoute(DepartureSectorEnum.SIN, DestinationSectorEnum.DXB)
    );
}