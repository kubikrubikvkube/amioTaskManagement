package com.github.kubikrubikvkube.amioTaskManagement.repository;

import com.github.kubikrubikvkube.amioTaskManagement.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {
}
