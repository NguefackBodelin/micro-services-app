package net.yousfi.billing_service.repository;

import net.yousfi.billing_service.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}
