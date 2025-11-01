import { useState } from "react";
import "../Calendar.css";

export const CalendarPage = () => {
  const [selectedDay, setSelectedDay] = useState(null);

  // Sahte etkinlik günleri (örnek amaçlı)
  const events = {
    3: ["React Hackathon", "Team Standup"],
    7: ["Design Demo"],
    14: ["Product Review", "Frontend Meeting"],
    17: ["API Release"],
    23: ["GDG Summit", "Sprint Retrospective", "Code Review"],
    31: ["Launch Party"],
  };

  return (
    <div className="calendar-main-container">
      {/* GEÇİCİ HEADER */}
      <div className="calendar-temp-header">Takvim & Etkinlikler</div>
      <div className="calendar-grid">
        {[...Array(35)].map((_, i) => {
          const day = i + 1;
          const hasEvent = !!events[day];
          const isOpen = selectedDay === day;
          return (
            <div
              key={day}
              className={`calendar-cell${isOpen ? " open" : ""}`}
              onClick={() => setSelectedDay(isOpen ? null : day)}
            >
              <span className="calendar-day-no">{day}</span>
              {/* Etkinlik dotları */}
              {hasEvent && (
                <div className="event-dots">
                  {events[day].map((ev, idx) => (
                    <span className="event-dot" key={idx}></span>
                  ))}
                </div>
              )}
              {/* Açılır pop-up etkinlik kartı */}
              {isOpen && hasEvent && (
                <div className="calendar-popup">
                  <div className="popup-header">Etkinlikler</div>
                  <ul className="popup-list">
                    {events[day].map((ev, idx) => (
                      <li key={idx}>{ev}</li>
                    ))}
                  </ul>
                </div>
              )}
            </div>
          );
        })}
      </div>
    </div>
  );
}
