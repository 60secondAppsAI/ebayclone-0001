import http from "../http-common"; 

class BiddingService {
  getAllBiddings(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/bidding/biddings`, searchDTO);
  }

  get(biddingId) {
    return this.getRequest(`/bidding/${biddingId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/bidding?field=${matchData}`, null);
  }

  addBidding(data) {
    return http.post("/bidding/addBidding", data);
  }

  update(data) {
  	return http.post("/bidding/updateBidding", data);
  }
  
  uploadImage(data,biddingId) {
  	return http.postForm("/bidding/uploadImage/"+biddingId, data);
  }




	postRequest(url, data) {
		return http.post(url, data);
      };

	getRequest(url, params) {
        return http.get(url, {
        	params: params
        });
    };

}

export default new BiddingService();
