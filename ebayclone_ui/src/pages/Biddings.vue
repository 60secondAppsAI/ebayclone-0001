<template>
  <div class="content">
    <div class="row">
      <div class="col-12">
        <card class="card-plain">
          <!-- <template slot="header">
            <h4 class="card-title">Table on Plain Background</h4>
            <p class="category">Here is a subtitle for this table</p>
          </template>-->
          <div class="table-full-width text-left">
            <bidding-table
            v-if="biddings && biddings.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:biddings="biddings"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-biddings="getAllBiddings"
             >

            </bidding-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import BiddingTable from "@/components/BiddingTable";
import BiddingService from "../services/BiddingService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    BiddingTable,
  },
  data() {
    return {
      biddings: [],
	  totalElements: 0,
      page: 0,
      searchQuery: '',     
      table1: {
        title: "Simple Table",
        columns: [...tableColumns],
        data: [...tableData],
      },
    };
  },
  methods: {
    async getAllBiddings(sortBy='biddingId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await BiddingService.getAllBiddings(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.biddings.length) {
					this.biddings = response.data.biddings;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching biddings:", error);
        }
        
      } catch (error) {
        console.error("Error fetching bidding details:", error);
      }
    },
  },
  mounted() {
    this.getAllBiddings();
  },
  created() {
    this.$root.$on('searchQueryForBiddingsChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllBiddings();
    })
  }
};
</script>
<style></style>
